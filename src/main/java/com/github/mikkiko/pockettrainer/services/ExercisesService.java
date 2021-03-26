package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.entity.Exercise;
import com.github.mikkiko.pockettrainer.entity.Image;

import java.util.List;
import java.util.Optional;

public interface ExercisesService {

    boolean saveExercise(Exercise exercise);

    Optional<Exercise> getExerciseById(Integer id);

    boolean removeExerciseById(Integer Id);

    List<Exercise> getAllExercises();

    Optional<Image> getExerciseImage(Integer id);

    void updateExercise(Exercise exercise);
}
