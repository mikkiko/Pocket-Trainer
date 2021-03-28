package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.dto.TrainingInfoDTO;

import java.util.List;
import java.util.Optional;

public interface TrainingInfoService {

    boolean saveTrainingInfo(TrainingInfoDTO dto);

    TrainingInfoDTO getTrainingInfoById(Integer id);

    List<TrainingInfoDTO> getTrainingsInfoList(List<Integer> ids);

    boolean saveTrainingsInfoList(List<TrainingInfoDTO> list);
}
