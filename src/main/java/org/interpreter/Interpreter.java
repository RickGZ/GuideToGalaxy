package org.interpreter;

import java.util.Arrays;
import java.util.Objects;

public class Interpreter implements IInterpreter {
    IGalacticDictionary galacticDictionary;
    INumeralCalculator numeralCalculator;
    public Interpreter() {
        galacticDictionary = new GalacticDictionary();
        numeralCalculator = new NumeralCalculator(galacticDictionary);
    }

    public String handleInput(String input) throws NoIdeaException {
        String[] inputStringArray = input.split(" ");
        if (inputStringArray.length < 3)
            throw new NoIdeaException();

        if(isValidSimpleSetStatement(inputStringArray)) { //Simple Set-Statement
            saveRomanToGalactic(inputStringArray);
        }
        else if (Objects.equals(inputStringArray[inputStringArray.length - 1].toLowerCase(), "credits")) {
            throw new NoIdeaException();
        }
        else if (input.toLowerCase().startsWith("how much is ")) {
            if (inputStringArray.length > 4) {
                String [] galacticNumerals = Arrays.copyOfRange(inputStringArray, 3, inputStringArray.length);
                return input.substring(12) + " is " + numeralCalculator.galacticNumeralsToInteger(galacticNumerals);
            }
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

    private boolean isValidSimpleSetStatement(String[] input) {
        //Set-Statement
        return Objects.equals(input[1].toLowerCase(), "is") && input.length == 3 && input[2].length() == 1;
    }
}
