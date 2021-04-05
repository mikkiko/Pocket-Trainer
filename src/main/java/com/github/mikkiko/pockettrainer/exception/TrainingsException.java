package com.github.mikkiko.pockettrainer.exception;

/**
 * Training exception extends {@link CustomException}.
 */

public class TrainingsException extends CustomException{

    public TrainingsException(String message) {
        super(message);
    }

    public TrainingsException(Cause cause) {
        super(cause);
    }

    public TrainingsException(Cause cause, Integer id) {
        super(cause, id);
    }
}
