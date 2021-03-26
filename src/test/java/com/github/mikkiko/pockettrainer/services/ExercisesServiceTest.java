package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.entity.Exercise;
import com.github.mikkiko.pockettrainer.entity.Image;
import com.github.mikkiko.pockettrainer.repository.ExerciseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Unit testing for {@link ExercisesService}.
 */
@ActiveProfiles("test")
@SpringBootTest
class ExercisesServiceTest {

    @MockBean
    private ExerciseRepository repository;

    @Autowired
    private ExercisesService exercisesService;

    @Test
    public void shouldProperlyGiveExercise() {
        Exercise expected = new Exercise()
                .setId(1)
                .setDescription("description")
                .setName("name")
                .setImage(new Image());
        given(repository.findById(1)).willReturn(Optional.of(expected));

        Exercise given = exercisesService.getExerciseById(1).orElse(null);
        assertThat(given).isNotNull().isEqualTo(expected);
    }

    @Test
    public void shouldGiveAllExercises() {
        List<Exercise> expectedList = new ArrayList<>(Arrays.asList(new Exercise(), new Exercise(), new Exercise()));
        given(repository.findAll()).willReturn(expectedList);

        List<Exercise> givenList = exercisesService.getAllExercises();
        assertThat(givenList).hasSize(3);
    }

    @Test
    public void shouldGiveExerciseImage() {
        Image image = new Image();
        Exercise exercise = new Exercise().setId(1).setImage(image);
        given(repository.findImageById(1)).willReturn(Optional.of(image));

        Image givenImage = exercisesService.getExerciseImage(1).orElse(null);
        assertThat(givenImage).isNotNull();
    }
}