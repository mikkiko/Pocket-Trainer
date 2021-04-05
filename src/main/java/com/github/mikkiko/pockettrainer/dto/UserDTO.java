package com.github.mikkiko.pockettrainer.dto;

import com.github.mikkiko.pockettrainer.entity.User;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Data transport object for {@link User}.
 */

@Data
@Accessors(chain = true)
public class UserDTO {

    private Integer id;
    private String email;
    private String nickname;
    private List<TrainingDTO> trainings;

}
