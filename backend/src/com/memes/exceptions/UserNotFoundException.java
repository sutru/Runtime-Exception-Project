package com.memes.exceptions;

public class UserNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -6692587435074250469L;

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }

}
