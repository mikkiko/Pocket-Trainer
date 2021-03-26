package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.entity.Exercise;
import com.github.mikkiko.pockettrainer.entity.Image;
import com.github.mikkiko.pockettrainer.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExercisesService{

    private final ExerciseRepository repository;

    @Override
    public boolean saveExercise(Exercise exercise) {
        repository.save(exercise);
        return repository.existsById(exercise.getId());
    }

    @Override
    public Optional<Exercise> getExerciseById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public boolean removeExerciseById(Integer id) {
        repository.deleteById(id);
        return !repository.existsById(id);
    }

    @Override
    public List<Exercise> getAllExercises() {
        return repository.findAll();
    }

    @Override
    public Optional<Image> getExerciseImage(Integer id){
        return repository.findImageById(id);
    }

    @Override
    public void updateExercise(Exercise exercise) {
        Optional<Exercise> oldExercise = repository.findById(exercise.getId());
        if(oldExercise.isPresent()){
            repository.save(exercise);
        }
    }
}
