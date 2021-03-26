package com.github.mikkiko.pockettrainer.repository;

import com.github.mikkiko.pockettrainer.entity.Exercise;
import com.github.mikkiko.pockettrainer.entity.Image;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

/**
 * Integration-level testing for {@link ExerciseRepository}.
 */
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class ExercisesRepositoryIT {

    @Autowired
    private ExerciseRepository repository;

    @Sql(scripts = {"/sql/clearDb.sql", "/sql/initDb.sql"})
    @Test
    public void shouldFindAllExercises() {
        List<Exercise> exercises = repository.findAll();

        assertThat(exercises).hasSize(5);
    }

    @Sql(scripts = {"/sql/clearDb.sql", "/sql/initDb.sql"})
    @Test
    public void shouldFindExerciseById() {
        Exercise exercise = repository.findById(1).orElse(null);

        assertThat(exercise).isNotNull();
    }

    @Sql(scripts = {"/sql/clearDb.sql", "/sql/initDb.sql"})
    @Test
    public void shouldFindExerciseImage() {
        Image image = repository.findImageById(1).orElse(null);

        assertThat(image).isNotNull();
    }
}
