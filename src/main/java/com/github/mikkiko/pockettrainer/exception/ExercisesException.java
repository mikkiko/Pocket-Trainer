package com.github.mikkiko.pockettrainer.exception;

/**
 * Exercise exception extends {@link CustomException}.
 */

public class ExercisesException extends CustomException{

    public ExercisesException(String message) {
        super(message);
    }

    public ExercisesException(Cause cause) {
        super(cause);
    }

    public ExercisesException(Cause cause, Integer id) {
        super(cause, id);
    }
}
