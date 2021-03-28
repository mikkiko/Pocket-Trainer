package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.dto.ExerciseDTO;
import com.github.mikkiko.pockettrainer.entity.Exercise;
import com.github.mikkiko.pockettrainer.entity.Image;

import java.util.List;
import java.util.Optional;

public interface ExercisesService {

    void saveExercise(Exercise exercise);

    ExerciseDTO getExerciseDTOById(Integer id);

    List<ExerciseDTO> getAllExercisesDTO();

    Optional<Image> getExerciseImage(Integer id);

    boolean removeExerciseById(Integer Id);
}
