package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.dto.TrainingDTO;
import com.github.mikkiko.pockettrainer.entity.Training;

import java.util.Optional;

public interface TrainingService {

    Optional<Training> getTrainingById(Integer id);

    TrainingDTO getTrainingDTOById(Integer id);

    void saveTraining(TrainingDTO dto);

    boolean updateTraining(TrainingDTO dto);

    boolean deleteTraining(Integer id);
}
