package com.github.mikkiko.pockettrainer.controllers;

import com.github.mikkiko.pockettrainer.dto.Response;
import com.github.mikkiko.pockettrainer.exception.CustomException;
import com.github.mikkiko.pockettrainer.exception.ExercisesException;
import com.github.mikkiko.pockettrainer.exception.TrainingsException;
import com.github.mikkiko.pockettrainer.exception.UserException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Class for handling exceptions:
 * {@link UserException},
 * {@link TrainingsException},
 * {@link ExercisesException}.
 */

@ControllerAdvice
public class DefaultAdvice {

    @ExceptionHandler({UserException.class, TrainingsException.class, ExercisesException.class})
    public Response handleException(CustomException e) {
        return new Response(null, e.getMessage());
    }
}
