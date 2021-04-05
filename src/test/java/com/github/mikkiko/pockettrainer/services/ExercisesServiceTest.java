package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.dto.ExerciseDTO;
import com.github.mikkiko.pockettrainer.entity.Exercise;
import com.github.mikkiko.pockettrainer.entity.Image;
import com.github.mikkiko.pockettrainer.exception.ExercisesException;
import com.github.mikkiko.pockettrainer.repository.ExerciseRepository;
import com.github.mikkiko.pockettrainer.util.EntityMapper;
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
    private ExerciseRepository repo;
    @Autowired
    private ExercisesService exercisesService;
    @Autowired
    private EntityMapper mapper;

    @Test
    public void shouldProperlyGiveExercise() throws ExercisesException {
        Exercise given = new Exercise()
                .setId(1)
                .setDescription("description")
                .setName("name")
                .setImage(new Image());
        given(repo.findById(1)).willReturn(Optional.of(given));

        ExerciseDTO expected = exercisesService.getExerciseDTOById(1);
        assertThat(expected).isEqualTo(mapper.fromEntityToExerciseDto(given));
    }

    @Test
    public void shouldGiveAllExercises() {
        List<Exercise> givenList = new ArrayList<>(Arrays.asList(
                new Exercise().setImage(new Image().setId(1)),
                new Exercise().setImage(new Image().setId(2)),
                new Exercise().setImage(new Image().setId(3))
        ));
        given(repo.findAll()).willReturn(givenList);

        List<ExerciseDTO> expectedList = exercisesService.getAllExercisesDTO();
        assertThat(expectedList).hasSize(3);
    }
}