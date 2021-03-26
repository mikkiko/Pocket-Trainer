package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.entity.Training;

import java.util.Optional;

public interface TrainingService {

    Optional<Training> getTrainingById(Integer id);

    boolean saveTraining(Training training);

    boolean deleteTraining(Integer id);

    boolean updateTraining(Training training);
}
