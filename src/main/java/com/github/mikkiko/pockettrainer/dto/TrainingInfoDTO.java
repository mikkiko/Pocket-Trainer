package com.github.mikkiko.pockettrainer.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TrainingInfoDTO {

    private Integer id;
    private Integer position;
    private Integer raps;
    private Integer trainingId;
    private Integer exerciseId;
    private String exerciseName;
    private String description;
    private Integer imageId;
}
