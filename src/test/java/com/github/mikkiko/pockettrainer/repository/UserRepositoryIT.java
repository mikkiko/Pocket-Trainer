package com.github.mikkiko.pockettrainer.repository;

import com.github.mikkiko.pockettrainer.entity.Training;
import com.github.mikkiko.pockettrainer.entity.User;
import com.github.mikkiko.pockettrainer.exception.UserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;


/**
 * Integration-level testing for {@link UserRepository}.
 */
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class UserRepositoryIT {

    @Autowired
    private UserRepository userRepository;

    @Sql(scripts = {"/sql/clearDb.sql", "/sql/initDb.sql"})
    @Test
    public void shouldProperlyFindAllUsers() {
        List<User> users = userRepository.findAll();

        Assertions.assertEquals(5, users.size());
    }

    @Sql(scripts = {"/sql/clearDb.sql"})
    @Test
    public void shouldProperlySaveAndDeleteUsers() throws UserException {
        User savedUser = new User()
                .setId(1)
                .setEmail("simple@mail.com")
                .setPassword("1111")
                .setNickname("name")
                .setTrainings(new ArrayList<>());

        userRepository.save(savedUser);
        User user = userRepository.findUserByEmail("simple@mail.com")
                .orElseThrow(UserException::new);

        Assertions.assertEquals(savedUser, user);

        userRepository.deleteById(1);
        Optional<User> deletedUser = userRepository.findById(1);

        Assertions.assertNull(deletedUser.orElse(null));
    }

    @Sql(scripts = {"/sql/clearDb.sql", "/sql/initDb.sql"})
    @Test
    public void shouldFindAllUsersTrainings() {
        List<Training> trainings = userRepository.getUserTrainings(1);

        assertThat(trainings).hasSize(3);
    }

    @Sql(scripts = {"/sql/clearDb.sql"})
    @Test
    public void shouldUpdateUsersTrainings() throws UserException {
        User newUser = new User().setTrainings(new ArrayList<>());
        userRepository.save(newUser);

        User user = userRepository.findById(1).orElseThrow(UserException::new);
        user.getTrainings().add(new Training());
        userRepository.save(user);

        List<Training> trainings = userRepository.getUserTrainings(1);
        assertThat(trainings).hasSize(1);

        user = userRepository.findById(1).orElseThrow(UserException::new);
        user.getTrainings().clear();
        userRepository.save(user);

        trainings = userRepository.getUserTrainings(1);
        assertThat(trainings).hasSize(0);
    }
}
