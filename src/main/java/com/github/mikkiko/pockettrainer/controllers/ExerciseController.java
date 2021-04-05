package com.github.mikkiko.pockettrainer.controllers;

import com.github.mikkiko.pockettrainer.dto.ExerciseDTO;
import com.github.mikkiko.pockettrainer.entity.Image;
import com.github.mikkiko.pockettrainer.exception.Cause;
import com.github.mikkiko.pockettrainer.exception.ExercisesException;
import com.github.mikkiko.pockettrainer.services.ExercisesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * {@link RestController} for getting {@link ExerciseDTO} and {@link Image}.
 */

@RestController
@RequestMapping("/exercise")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExercisesService exercisesService;

    @GetMapping
    public ResponseEntity<?> getAllExercise(){
        List<ExerciseDTO> dtoList = exercisesService.getAllExercisesDTO();
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getExercise(@PathVariable(name = "id") Integer id)
            throws ExercisesException {
        ExerciseDTO dto = exercisesService.getExerciseDTOById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<?> getImage(@PathVariable(name = "id") Integer id) throws ExercisesException {
        Image image = exercisesService.getExerciseImage(id).orElseThrow(
                () -> new ExercisesException(Cause.IMAGE_NOT_FOUND, id));
        return ResponseEntity.ok(image);
    }
}
