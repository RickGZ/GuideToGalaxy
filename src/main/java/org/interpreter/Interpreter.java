package org.interpreter;

import java.util.Objects;

public class Interpreter implements IInterpreter {
    IGalacticDictionary galacticDictionary;
    public Interpreter() {
        galacticDictionary = new GalacticDictionary();
    }

    public String handleInput(String input) throws NoIdeaException {
        String[] inputStringArray = input.split(" ");
        if (inputStringArray.length < 3)
            throw new NoIdeaException();

        if(Objects.equals(inputStringArray[1], "is")) { //Set-Statement
            boolean isValidSetStatement = validateSetStatement(inputStringArray);
            if (!isValidSetStatement)
                throw new NoIdeaException();

            saveRomanToGalactic(inputStringArray);
        }
        else if (input.toLowerCase().startsWith("how much is ")) {
            if (inputStringArray.length == 4)
                return "" + galacticDictionary.getIntegerValueForGalacticNumeral(inputStringArray[3]); //basic implementation, no calc
        }
        else {
            throw new NoIdeaException();
        }

        return "Input processed.";
    }

    private void saveRomanToGalactic(String[] input) {
        String galactic = input[0];
        String roman = input[2];
        galacticDictionary.setRomanGalactic(roman, galactic);
    }

    private boolean validateSetStatement(String[] input) {
        //Set-Statement
        return Objects.equals(input[1].toLowerCase(), "is") && input.length == 3 && input[2].length() == 1;
    }
}
