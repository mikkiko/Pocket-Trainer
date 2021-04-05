package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.dto.TrainingInfoDTO;
import com.github.mikkiko.pockettrainer.entity.Training;
import com.github.mikkiko.pockettrainer.entity.Exercise;
import com.github.mikkiko.pockettrainer.entity.TrainingInfo;
import com.github.mikkiko.pockettrainer.exception.ExercisesException;
import com.github.mikkiko.pockettrainer.exception.TrainingsException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * {@link Service} for handling {@link TrainingInfo} entity.
 */

public interface TrainingInfoService {

    /**
     * Save provided {@link TrainingInfoDTO}.
     *
     * @param dto provided {@link TrainingInfoDTO}.
     * @throws TrainingsException if {@link Training} from provided dto does not exist.
     * @throws ExercisesException if {@link Exercise} from provided dto does not exist.
     */
    void saveTrainingInfo(TrainingInfoDTO dto) throws TrainingsException, ExercisesException;

    /**
     * Find {@link TrainingInfoDTO}.
     *
     * @param id provided {@link TrainingInfo}.
     * @return {@link TrainingInfoDTO} with provided ID or null otherwise.
     * @throws TrainingsException if {@link TrainingInfo} with prided ID does not exist.
     */
    TrainingInfoDTO getTrainingInfoById(Integer id) throws TrainingsException;

    /**
     * Find all {@link TrainingInfoDTO} with provided id's.
     *
     * @param id provided {@link List} of {@link Integer} .
     * @return {@link TrainingInfoDTO} with provided ID or null otherwise.
     * @throws TrainingsException if {@link TrainingInfo} with prided ID does not exist.
     */
    List<TrainingInfoDTO> getTrainingsInfoList(List<Integer> id) throws TrainingsException;

    /**
     * Save {@link List} of {@link TrainingInfoDTO}.
     *
     * @param trainingInfoDTOs provided {@link List} of {@link TrainingInfoDTO} .
     * @throws TrainingsException if {@link Training} from provided dto does not exist.
     * @throws ExercisesException if {@link Exercise} from provided dto does not exist.
     */
    void saveTrainingsInfoList(List<TrainingInfoDTO> trainingInfoDTOs)
            throws TrainingsException, ExercisesException;
}
