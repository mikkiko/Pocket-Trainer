package com.github.mikkiko.pockettrainer.controllers;

import com.github.mikkiko.pockettrainer.dto.TrainingDTO;
import com.github.mikkiko.pockettrainer.dto.TrainingInfoDTO;
import com.github.mikkiko.pockettrainer.entity.User;
import com.github.mikkiko.pockettrainer.exception.ExercisesException;
import com.github.mikkiko.pockettrainer.exception.TrainingsException;
import com.github.mikkiko.pockettrainer.services.TrainingInfoService;
import com.github.mikkiko.pockettrainer.services.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * {@link RestController} for registration new {@link User}.
 */

@RestController
@RequestMapping("/training")
@RequiredArgsConstructor
public class TrainingController {

    private final TrainingService trainingService;
    private final TrainingInfoService trainingInfoService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getTraining(@PathVariable(name = "id") Integer id)
            throws TrainingsException {
        TrainingDTO dto = trainingService.getTrainingDTOById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<?> addTraining(@RequestBody TrainingDTO dto){
        trainingService.saveTraining(dto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateTraining(@RequestBody TrainingDTO dto)
            throws TrainingsException {
        trainingService.updateTraining(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTraining(@PathVariable(name = "id") Integer id) {
        trainingService.deleteTraining(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<?> getTrainingInfo(@PathVariable(name = "id") Integer id)
            throws TrainingsException {
        TrainingInfoDTO dto = trainingInfoService.getTrainingInfoById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/info")
    public ResponseEntity<?> getAllTrainingInfo(@RequestParam List<Integer> trainingsId)
            throws TrainingsException {
        List<TrainingInfoDTO> dtoList = trainingInfoService.getTrainingsInfoList(trainingsId);
        return ResponseEntity.ok(dtoList);
    }

    @PostMapping("/info")
    public ResponseEntity<?> saveTrainingInfo(@RequestBody List<TrainingInfoDTO> info)
            throws TrainingsException, ExercisesException {
        trainingInfoService.saveTrainingsInfoList(info);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
