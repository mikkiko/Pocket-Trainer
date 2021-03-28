package com.github.mikkiko.pockettrainer.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ExerciseDTO {

    private Integer id;
    private String name;
    private String description;
    private Integer imageId;
}
