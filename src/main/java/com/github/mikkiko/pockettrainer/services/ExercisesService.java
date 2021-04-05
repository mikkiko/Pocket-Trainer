package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.dto.ExerciseDTO;
import com.github.mikkiko.pockettrainer.entity.Exercise;
import com.github.mikkiko.pockettrainer.entity.Image;
import com.github.mikkiko.pockettrainer.entity.User;
import com.github.mikkiko.pockettrainer.exception.ExercisesException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * {@link Service} for handling {@link Exercise} entity.
 */

public interface ExercisesService {

    /**
     * Save provided {@link Exercise} entity.
     *
     * @param exercise provided {@link Exercise}.
     */
    void saveExercise(Exercise exercise);

    /**
     * Get {@link Exercise} DTO.
     *
     * @param id provided {@link Exercise} id.
     * @return {@link ExerciseDTO} with provided ID.
     * @throws ExercisesException if exercise with provided ID does not exist.
     */
    ExerciseDTO getExerciseDTOById(Integer id) throws ExercisesException;

    /**
     * Retrieve all {@link Exercise} DTO.
     *
     * @return {@link List} of {@link ExerciseDTO}.
     */
    List<ExerciseDTO> getAllExercisesDTO();

    /**
     * Find exercises {@link Image}.
     *
     * @param id provided {@link Exercise} id.
     * @return {@link Image} with provided {@link Exercise} ID or null otherwise.
     */
    Optional<Image> getExerciseImage(Integer id);

    /**
     * Delete {@link Exercise}.
     *
     * @param id provided {@link Exercise} id.
     * @return true if {@link Exercise} with provided ID was successfully delete or false in the other case.
     */
    boolean removeExerciseById(Integer id);
}
