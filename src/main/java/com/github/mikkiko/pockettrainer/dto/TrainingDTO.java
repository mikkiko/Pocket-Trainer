package com.github.mikkiko.pockettrainer.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class TrainingDTO {

    private Integer id;
    private String name;
    private Integer rounds;
    private Integer time;
    private List<Integer> trainingsInfo;
}
