package com.github.mikkiko.pockettrainer.repository;

import com.github.mikkiko.pockettrainer.entity.Training;
import com.github.mikkiko.pockettrainer.entity.User;
import com.github.mikkiko.pockettrainer.exception.NoSuchUserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * Integration-level testing for {@link UserRepository}.
 */
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class UserRepositoryIT {

    @Autowired
    private UserRepository repository;

    @Sql(scripts = {"/sql/clearDb.sql", "/sql/initDb.sql"})
    @Test
    public void shouldProperlyFindAllUsers() {
        List<User> users = repository.findAll();

        Assertions.assertEquals(5, users.size());
    }

    @Sql(scripts = {"/sql/clearDb.sql", "/sql/initDb.sql"})
    @Test
    public void shouldProperlySaveAndDeleteUsers() throws NoSuchUserException {
        User savedUser = new User().setEmail("simple@mail.com");
        repository.save(savedUser);
        Optional<User> gotUser = repository.findById("simple@mail.com");

        Assertions.assertEquals(savedUser, gotUser.orElseThrow(NoSuchUserException::new));

        repository.deleteById("simple@mail.com");
        Optional<User> user = repository.findById("simple@mail.com");

        Assertions.assertNull(user.orElse(null));
    }

    @Sql(scripts = {"/sql/clearDb.sql", "/sql/initDb.sql"})
    @Test
    public void shouldFindAllUsersTrainings() {
        List<Training> trainings = repository.getUserTrainings("abc1@mail.com");

        assertThat(trainings).hasSize(3);
    }

    @Sql(scripts = {"/sql/clearDb.sql", "/sql/initDb.sql"})
    @Test
    public void shouldUpdateUsersTrainings() throws NoSuchUserException {
        User user = repository.findById("abc1@mail.com").orElseThrow(NoSuchUserException::new);
        user.getTrainings().add(new Training());
        repository.save(user);
        List<Training> trainings = repository.getUserTrainings("abc1@mail.com");

        assertThat(trainings).hasSize(1);

        user = repository.findById("abc1@mail.com").orElseThrow(NoSuchUserException::new);
        user.getTrainings().clear();
        repository.save(user);
        trainings = repository.getUserTrainings("abc1@mail.com");

        assertThat(trainings).hasSize(0);
    }
}
