package com.github.mikkiko.pockettrainer.util;

import com.github.mikkiko.pockettrainer.dto.*;
import com.github.mikkiko.pockettrainer.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntityMapper {

    public User fromUserDtoToEntity(UserDTO dto) {
        return new User()
                .setEmail(dto.getEmail())
                .setName(dto.getName())
                .setTrainings(dto.getTrainings()
                        .stream()
                        .map(this::fromTrainingDtoToEntity)
                        .collect(Collectors.toList()));
    }

    public Training fromTrainingDtoToEntity(TrainingDTO dto) {
        return new Training()
                .setId(dto.getId())
                .setName(dto.getName())
                .setTime(dto.getTime())
                .setRounds(dto.getRounds());
    }

    public TrainingInfo fromTrainingInfoDtoToEntity(TrainingInfoDTO dto, Training training, Exercise exercise) {
        return new TrainingInfo()
                .setId(dto.getId())
                .setPosition(dto.getPosition())
                .setReps(dto.getRaps())
                .setTraining(training)
                .setExercise(exercise);

    }

    public UserDTO fromEntityToUserDto(User user) {
        return new UserDTO()
                .setEmail(user.getEmail())
                .setName(user.getName())
                .setTrainings(user.getTrainings()
                        .stream()
                        .map(this::fromEntityToTrainingDto)
                        .collect(Collectors.toList()));
    }

    public TrainingDTO fromEntityToTrainingDto(Training training) {
        return new TrainingDTO()
                .setId(training.getId())
                .setName(training.getName())
                .setRounds(training.getRounds())
                .setTime(training.getTime())
                .setTrainingsInfo(training.getTrainingInfo() == null
                        ? null : training.getTrainingInfo()
                        .stream()
                        .map(TrainingInfo::getId)
                        .collect(Collectors.toList()));
    }

    public TrainingInfoDTO fromEntityToTrainingInfoDto(TrainingInfo info) {
        Exercise exercise = info.getExercise();
        return new TrainingInfoDTO()
                .setId(info.getId())
                .setPosition(info.getPosition())
                .setRaps(info.getReps())
                .setTrainingId(info.getTraining().getId())
                .setExerciseId(exercise.getId())
                .setExerciseName(exercise.getName())
                .setDescription(exercise.getDescription())
                .setImageId(exercise.getImage().getId());
    }

    public List<ExerciseDTO> fromEntityToExerciseDtoList(List<Exercise> list){
        return list
                .stream()
                .map(this::fromEntityToExerciseDto)
                .collect(Collectors.toList());
    }

    public ExerciseDTO fromEntityToExerciseDto(Exercise exercise){
        return new ExerciseDTO()
                .setId(exercise.getId())
                .setName(exercise.getName())
                .setDescription(exercise.getDescription())
                .setImageId(exercise.getImage().getId());
    }
}
