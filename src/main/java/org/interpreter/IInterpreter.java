package org.interpreter;

import org.interpreter.Exceptions.NoIdeaException;

public interface IInterpreter {
    String handleInput(String input) throws NoIdeaException;
}
