package com.memes.exceptions;

public class InvalidInputException extends RuntimeException {

    private static final long serialVersionUID = 2831262393266192231L;

    public InvalidInputException() {
        super();
    }

    public InvalidInputException(String message) {
        super(message);
    }

}
