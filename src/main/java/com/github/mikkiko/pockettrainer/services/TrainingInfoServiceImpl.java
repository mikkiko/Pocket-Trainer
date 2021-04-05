package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.dto.TrainingInfoDTO;
import com.github.mikkiko.pockettrainer.entity.Exercise;
import com.github.mikkiko.pockettrainer.entity.Training;
import com.github.mikkiko.pockettrainer.entity.TrainingInfo;
import com.github.mikkiko.pockettrainer.exception.Cause;
import com.github.mikkiko.pockettrainer.exception.ExercisesException;
import com.github.mikkiko.pockettrainer.exception.TrainingsException;
import com.github.mikkiko.pockettrainer.repository.ExerciseRepository;
import com.github.mikkiko.pockettrainer.repository.TrainingInfoRepository;
import com.github.mikkiko.pockettrainer.repository.TrainingRepository;
import com.github.mikkiko.pockettrainer.util.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of {@link TrainingInfoService}.
 */

@Service
@RequiredArgsConstructor
public class TrainingInfoServiceImpl implements TrainingInfoService {

    private final TrainingInfoRepository infoRepo;
    private final TrainingRepository trainingRepo;
    private final ExerciseRepository exerciseRepo;
    private final EntityMapper mapper;

    @Override
    public void saveTrainingInfo(TrainingInfoDTO dto) throws TrainingsException, ExercisesException {
        Exercise exercise = exerciseRepo.findById(dto.getExerciseId()).orElseThrow(
                () -> new ExercisesException(Cause.EXERCISE_NOT_FOUND, dto.getExerciseId()));

        Training training = trainingRepo.findById(dto.getTrainingId()).orElseThrow(
                () -> new TrainingsException(Cause.TRAINING_NOT_FOUND, dto.getTrainingId()));
        infoRepo.save(mapper.fromTrainingInfoDtoToEntity(dto, training, exercise));
    }

    @Override
    public TrainingInfoDTO getTrainingInfoById(Integer id) throws TrainingsException {
        TrainingInfo info = infoRepo.findById(id).orElseThrow(
                () -> new TrainingsException(Cause.TRAINING_NOT_FOUND, id));
        return mapper.fromEntityToTrainingInfoDto(info);
    }

    @Override
    public List<TrainingInfoDTO> getTrainingsInfoList(List<Integer> infosID) throws TrainingsException {
        List<TrainingInfoDTO> trainingInfoDTOList = new ArrayList<>();
        for (Integer id : infosID)
            trainingInfoDTOList.add(getTrainingInfoById(id));
        return trainingInfoDTOList;
    }

    @Override
    public void saveTrainingsInfoList(List<TrainingInfoDTO> trainingInfoDTOs)
            throws TrainingsException, ExercisesException {
        if (!trainingInfoDTOs.isEmpty()) {
            TrainingInfoDTO first = trainingInfoDTOs.get(0);
            final Exercise exercise = exerciseRepo.findById(first.getExerciseId()).orElseThrow(
                    () -> new ExercisesException(Cause.EXERCISE_NOT_FOUND, first.getExerciseId()));
            final Training training = trainingRepo.findById(first.getTrainingId()).orElseThrow(
                    () -> new TrainingsException(Cause.TRAINING_NOT_FOUND, first.getTrainingId()));
            List<TrainingInfo> entityList = trainingInfoDTOs
                    .stream()
                    .map(dto -> mapper.fromTrainingInfoDtoToEntity(dto, training, exercise))
                    .collect(Collectors.toList());
            entityList.forEach(infoRepo::save);
        } else throw new TrainingsException(Cause.TRAINING_LIST_EMPTY);
    }
}
