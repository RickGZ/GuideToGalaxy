package org.interpreter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class InterpreterTest {
    IInterpreter interpreter;

    @BeforeEach
    void setUp() {
        interpreter = new Interpreter();
    }

    @Test
    void handleInput() throws NoIdeaException {
        //Arrange
        String inputGlobIsI = "glob is I";
        String inputProkIsV = "prok is V";
        String inputGoldCredits = "glob prok Gold is 57800 Credits";
        String inputProcessed = "Input processed.";

        String inputHowMuchNumerals = "how much is glob prok ?"; //IV = 4
        String inputCreditsToGold = "how many Credits is glob Gold ?"; //one gold is 14450 Credits
        String invalidQuestion = "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?";

        //Act
        String resultInputGlobIsI = interpreter.handleInput(inputGlobIsI);
        String resultInputProkIsV = interpreter.handleInput(inputProkIsV);
        String resultInputGoldCredits = interpreter.handleInput(inputGoldCredits);

        String resultInputHowMuchNumerals = interpreter.handleInput(inputHowMuchNumerals);
        String resultInputCreditsToGold = interpreter.handleInput(inputCreditsToGold);

        //Assert
        assertEquals(inputProcessed, resultInputGlobIsI);
        assertEquals(inputProcessed, resultInputProkIsV);
        assertEquals(inputProcessed, resultInputGoldCredits);

        assertEquals("glob prok is 4", resultInputHowMuchNumerals);
        assertEquals("glob Gold is 14450 Credits", resultInputCreditsToGold);

        assertThrows(NoIdeaException.class, () -> interpreter.handleInput(invalidQuestion));
    }
}