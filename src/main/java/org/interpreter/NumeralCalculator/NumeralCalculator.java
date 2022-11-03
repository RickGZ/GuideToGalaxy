package org.interpreter.NumeralCalculator;

import org.interpreter.GalacticDictionary.IGalacticDictionary;

public class NumeralCalculator implements INumeralCalculator {
    IGalacticDictionary galacticDictionary;

    public NumeralCalculator(IGalacticDictionary givenDictionary) {
        galacticDictionary = givenDictionary;
    }

    public int galacticNumeralsToInteger(String[] galacticNumerals) {
        int result = 0;
        for (int i = 0; i < galacticNumerals.length; i++) {
            int currentNumeral = galacticDictionary.getIntegerValueForGalacticNumeral(galacticNumerals[i]);

            if (i == 0) {
                result += currentNumeral;
                continue;
            }

            int previousNumeral = galacticDictionary.getIntegerValueForGalacticNumeral(galacticNumerals[i - 1]);
            if (currentNumeral > previousNumeral) {
                result += currentNumeral - (2 * previousNumeral);
            }
            else {
                result += currentNumeral;
            }
        }

        return result;
    }
}
