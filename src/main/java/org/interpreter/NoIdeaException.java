package org.interpreter;

public class NoIdeaException extends Exception {
    public NoIdeaException(String errorMessage) {
        super(errorMessage);
    }

    public NoIdeaException() {
        super("I have no idea what you are talking about");
    }
}
