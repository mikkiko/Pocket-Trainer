package com.github.mikkiko.pockettrainer.repository;

import com.github.mikkiko.pockettrainer.entity.Exercise;
import com.github.mikkiko.pockettrainer.entity.Training;
import com.github.mikkiko.pockettrainer.entity.TrainingsExercises;
import com.github.mikkiko.pockettrainer.exception.NoSuchTrainingException;
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
 * Integration-level testing for {@link TrainingRepository}.
 */
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class TrainingRepositoryIT {

    @Autowired
    private TrainingRepository repository;

    @Sql(scripts = {"/sql/clearDb.sql", "/sql/initDb.sql"})
    @Test
    public void shouldProperlyFindTraining() throws NoSuchTrainingException {
        Training training = repository.findById(1).orElseThrow(NoSuchTrainingException::new);
        assertThat(training.getName()).isEqualTo("training1");
    }

    @Sql(scripts = {"/sql/clearDb.sql", "/sql/initDb.sql"})
    @Test
    public void shouldProperlyDeleteTraining(){
        repository.deleteById(1);
        Training training = repository.findById(1).orElse(null);
        assertThat(training).isNull();
    }

    @Sql(scripts = {"/sql/clearDb.sql", "/sql/initDb.sql"})
    @Test
    public void shouldProperlyFindAllExercisesByTrainingId(){
        List<Exercise> exercises = repository.findExercises(1);

        assertThat(exercises).hasSize(3);
    }

    @Sql(scripts = {"/sql/clearDb.sql", "/sql/initDb.sql"})
    @Test
    public void shouldProperlyFindAllTrainingsExercises(){
        List<TrainingsExercises> training = repository.findTrainingsExercises(1);

        assertThat(training).hasSize(3);
    }
}
