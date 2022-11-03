package org.interpreter;

import org.interpreter.Exceptions.NoIdeaException;
import org.interpreter.GalacticDictionary.GalacticDictionary;
import org.interpreter.GalacticDictionary.IGalacticDictionary;
import org.interpreter.NumeralCalculator.INumeralCalculator;
import org.interpreter.NumeralCalculator.NumeralCalculator;

import java.util.Arrays;
import java.util.Objects;

import static java.lang.Math.round;

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

        if(isSimpleSetStatement(inputStringArray)) {
            saveRomanToGalactic(inputStringArray);
        }
        else if (isUnitValueSetStatement(inputStringArray)) {
            processUnitValueSetStatement(inputStringArray);
        }
        else if (isHowManyCreditsQuestion(input, inputStringArray)) {
            return processHowManyCreditsQuestion(inputStringArray);
        }
        else if (isHowMuchQuestion(input, inputStringArray)) {
            return processHowMuchQuestion(input, inputStringArray);
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

    private String processHowManyCreditsQuestion(String[] input) throws NoIdeaException {
        String unit = input[input.length - 2]; //Unit comes before question mark
        float valuePerUnit = galacticDictionary.getValuePerUnit(unit);
        if (valuePerUnit == -1)
            throw new NoIdeaException();

        int galacticNumeralsStart = 4; //galactic numerals start at index 4
        int galacticNumeralsEnd = input.length - 2; //final galactic numeral comes before unit keyword
        String[] galacticNumerals = Arrays.copyOfRange(input, galacticNumeralsStart, galacticNumeralsEnd);
        int amountOfUnit = numeralCalculator.galacticNumeralsToInteger(galacticNumerals);

        if (amountOfUnit <= 0)
            throw new NoIdeaException();

        int result = round(amountOfUnit * valuePerUnit);
        return String.join(" ", galacticNumerals) + " " + unit +  " is " + result + " Credits";
    }

    private void processUnitValueSetStatement(String[] input) {
        int indexOfUnitValue = 0;
        String unit = "";
        int creditsForAmountOfUnit = Integer.parseInt(input[input.length - 2]); //Amount comes before the word "Credits"

        for (int i = 0; i < input.length; i++) {
            if (Character.isUpperCase(input[i].charAt(0))) {
                indexOfUnitValue = i;
                unit = input[i];
                break;
            }
        }
        String[] galacticNumerals = Arrays.copyOfRange(input, 0, indexOfUnitValue);
        int amountOfUnit = numeralCalculator.galacticNumeralsToInteger(galacticNumerals);

        float creditsPerUnit = (float) creditsForAmountOfUnit / amountOfUnit;

        galacticDictionary.setValuePerUnit(unit, creditsPerUnit);
    }

    private String processHowMuchQuestion (String inputString, String[] input) {
        String [] galacticNumerals = Arrays.copyOfRange(input, 3, input.length);
        return inputString.substring(12, inputString.length() - 2) + " is " + numeralCalculator.galacticNumeralsToInteger(galacticNumerals);
    }

    private boolean isSimpleSetStatement(String[] input) {
        return Objects.equals(input[1].toLowerCase(), "is")
                && input.length == 3
                && input[2].length() == 1
                && galacticDictionary.isExistingRomanNumeral(input[2].toUpperCase());
    }

    private boolean isHowMuchQuestion(String inputString, String[] input) {
        return inputString.toLowerCase().startsWith("how much is ")
                && input.length >= 4
                && Objects.equals(input[input.length - 1], "?");
    }

    private boolean isHowManyCreditsQuestion(String inputString, String[] input) {
        //Check for following type of question
        //> how many Credits is glob prok Silver ?
        if (!inputString.toLowerCase().startsWith("how many credits is "))
            return false;

        if(!Objects.equals(input[input.length - 1], "?"))
            return false;

        return true;
    }

    private boolean isUnitValueSetStatement(String[] input) {
        //Checks whether:
        //"Credits" is the last word of the input
        //String contains exactly one word other than "Credits" that starts with a capital letter
        //String that comes before Credits is a valid integer value
        return Objects.equals(input[input.length - 1].toLowerCase(), "credits")
                && Arrays.stream(input).filter(x -> !Objects.equals(x, "Credits")
                    && Character.isUpperCase(x.charAt(0))).count() == 1;
    }
}
