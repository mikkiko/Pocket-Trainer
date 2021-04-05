package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.dto.TrainingDTO;
import com.github.mikkiko.pockettrainer.entity.Training;
import com.github.mikkiko.pockettrainer.exception.TrainingsException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * {@link Service} for handling {@link Training} entity.
 */

public interface TrainingService {

    /**
     * Find {@link Training} by ID.
     *
     * @param id provided Training ID
     * @return {@link Training} with provided ID or null otherwise.
     */
    Optional<Training> getTrainingById(Integer id);

    /**
     * Get {@link TrainingDTO} by ID.
     *
     * @param id provided {@link Training} ID
     * @return {@link TrainingDTO} with provided ID or null otherwise.
     * @throws TrainingsException if training with provided ID do not exist.
     */
    TrainingDTO getTrainingDTOById(Integer id) throws TrainingsException;

    /**
     * Save provided {@link TrainingDTO}.
     *
     * @param dto provided {@link TrainingDTO}
     */
    void saveTraining(TrainingDTO dto);

    /**
     * Update {@link TrainingDTO}.
     *
     * @param dto provided {@link TrainingDTO} with all needed information.
     * @throws TrainingsException if training do not exist.
     */
    void updateTraining(TrainingDTO dto) throws TrainingsException;

    /**
     * Delete {@link Training}.
     *
     * @param id provided {@link Training} ID.
     * @return true if {@link Training} was deleted or false in the other case.
     */
    boolean deleteTraining(Integer id);
}
