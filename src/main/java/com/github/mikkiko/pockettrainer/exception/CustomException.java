package com.github.mikkiko.pockettrainer.exception;

/**
 * Abstract custom exception extends {@link Exception}.
 */

public abstract class CustomException extends Exception{

    public CustomException(String message) {
        super(message);
    }

    public CustomException(Cause cause) {
        super(cause.getCause());
    }

    public CustomException(Cause cause, Integer id) {
        super(String.format(cause.getCause(), id));
    }

    public CustomException() { }
}
