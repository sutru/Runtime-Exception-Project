package com.memes.exceptions;

public class DuplicateMemeFoundException extends RuntimeException {
    private static final long serialVersionUID = -3492813628810194281L;

    public DuplicateMemeFoundException() {
        super();
    }

    public DuplicateMemeFoundException(String message) {
        super(message);
    }
}
