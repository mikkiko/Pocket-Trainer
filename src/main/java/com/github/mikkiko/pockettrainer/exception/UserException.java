package com.github.mikkiko.pockettrainer.exception;

/**
 * User exception extends {@link CustomException}.
 */

public class UserException extends CustomException {

    public UserException(String message) {
        super(message);
    }

    public UserException(Cause cause) {
        super(cause);
    }

    public UserException(Cause cause, Integer id) {
        super(cause, id);
    }

    public UserException() {
        super();
    }
}
