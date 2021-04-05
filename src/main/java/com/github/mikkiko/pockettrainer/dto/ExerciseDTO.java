package com.github.mikkiko.pockettrainer.dto;

import com.github.mikkiko.pockettrainer.entity.Exercise;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Data transport object for {@link Exercise}.
 */

@Data
@Accessors(chain = true)
public class ExerciseDTO {

    private Integer id;
    private String name;
    private String description;
    private Integer imageId;
}
