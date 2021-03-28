package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.dto.TrainingInfoDTO;
import com.github.mikkiko.pockettrainer.entity.Exercise;
import com.github.mikkiko.pockettrainer.entity.Training;
import com.github.mikkiko.pockettrainer.entity.TrainingInfo;
import com.github.mikkiko.pockettrainer.exception.NoSuchExerciseException;
import com.github.mikkiko.pockettrainer.exception.NoSuchInfoException;
import com.github.mikkiko.pockettrainer.exception.NoSuchTrainingException;
import com.github.mikkiko.pockettrainer.repository.ExerciseRepository;
import com.github.mikkiko.pockettrainer.repository.TrainingInfoRepository;
import com.github.mikkiko.pockettrainer.repository.TrainingRepository;
import com.github.mikkiko.pockettrainer.util.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrainingInfoServiceImpl implements TrainingInfoService {

    private final TrainingInfoRepository infoRepo;
    private final TrainingRepository trainingRepo;
    private final ExerciseRepository exerciseRepo;
    private final EntityMapper mapper;

    @Override
    public boolean saveTrainingInfo(TrainingInfoDTO dto) {
        try {
            Exercise exercise = exerciseRepo.findById(dto.getExerciseId())
                    .orElseThrow(NoSuchExerciseException::new);
            Training training = trainingRepo.findById(dto.getTrainingId())
                    .orElseThrow(NoSuchTrainingException::new);

            infoRepo.save(mapper.fromTrainingInfoDtoToEntity(dto, training, exercise));
            return true;
        } catch (NoSuchExerciseException | NoSuchTrainingException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public TrainingInfoDTO getTrainingInfoById(Integer id) {
        TrainingInfoDTO dto = null;
        try {
            TrainingInfo info = infoRepo.findById(id).orElseThrow(NoSuchInfoException::new);
            dto = mapper.fromEntityToTrainingInfoDto(info);
        } catch (NoSuchInfoException e) {
            e.printStackTrace();
        }
        return dto;
    }

    @Override
    public List<TrainingInfoDTO> getTrainingsInfoList(List<Integer> ids) {
        return ids
                .stream()
                .map(this::getTrainingInfoById)
                .collect(Collectors.toList());
    }

    @Override
    public boolean saveTrainingsInfoList(List<TrainingInfoDTO> dtoList) {
        try {
            if (!dtoList.isEmpty()) {
                TrainingInfoDTO first = dtoList.get(0);
                final Exercise exercise = exerciseRepo.findById(first.getExerciseId())
                        .orElseThrow(NoSuchExerciseException::new);
                final Training training = trainingRepo.findById(first.getTrainingId())
                        .orElseThrow(NoSuchTrainingException::new);
                List<TrainingInfo> entityList = dtoList
                        .stream()
                        .map(dto -> mapper.fromTrainingInfoDtoToEntity(dto, training, exercise))
                        .collect(Collectors.toList());
                entityList.forEach(infoRepo::save);
                return true;
            }
        }catch (NoSuchExerciseException | NoSuchTrainingException e){
            e.printStackTrace();
        }
        return false;
    }
}
