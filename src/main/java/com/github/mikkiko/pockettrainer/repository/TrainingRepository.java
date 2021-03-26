package com.github.mikkiko.pockettrainer.repository;

import com.github.mikkiko.pockettrainer.entity.Exercise;
import com.github.mikkiko.pockettrainer.entity.Training;
import com.github.mikkiko.pockettrainer.entity.TrainingsExercises;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer> {

    @Query("SELECT e FROM Exercise e WHERE e.id IN (SELECT tr.id FROM TrainingsExercises tr WHERE tr.training.id = :id)")
    List<Exercise> findExercises(Integer id);

    @Query("SELECT tr FROM TrainingsExercises tr WHERE tr.training.id = :id")
    List<TrainingsExercises> findTrainingsExercises(Integer id);
}
