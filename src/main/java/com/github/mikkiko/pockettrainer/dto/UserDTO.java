package com.github.mikkiko.pockettrainer.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class UserDTO {

    private String email;
    private String name;
    private List<TrainingDTO> trainings;

}
