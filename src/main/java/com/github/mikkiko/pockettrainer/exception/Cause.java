package com.github.mikkiko.pockettrainer.exception;

/**
 * Enumeration of causes for {@link CustomException}.
 */

public enum Cause {
    USER_NOT_FOUND("User with id %d not found."),
    USER_NOT_MODIFIED("User with id %d not modified."),
    TRAINING_NOT_FOUND("Training with id %d not found."),
    TRAINING_NOT_MODIFIED("Training with id %d not modified."),
    TRAINING_INFO_NOT_FOUND("Training info with id %d not found."),
    TRAINING_LIST_EMPTY("List of trainings is empty"),
    EXERCISE_NOT_FOUND("Exception with id %d not found."),
    IMAGE_NOT_FOUND("Image with id %d not found.");

    private String cause;

    Cause(String cause){
        this.cause = cause;
    }
    public String getCause(){
        return cause;
    }
}
