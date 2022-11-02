package org.interpreter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumeralCalculatorTest {
    private IGalacticDictionary galacticDictionary;
    private INumeralCalculator numeralCalculator;

    @BeforeEach
    void arrange() {
        galacticDictionary = new GalacticDictionary();
        numeralCalculator = new NumeralCalculator(galacticDictionary);
    }

    @Test
    void galacticNumeralsToInteger() {
        //Arrange
        int result;
        String[] inputArray = new String[] {
                "murk",
                "curk",
                "murk",
                "vurk",
                "iurk"
        };
        galacticDictionary.setRomanGalactic("M", "murk");
        galacticDictionary.setRomanGalactic("C", "curk");
        galacticDictionary.setRomanGalactic("V", "vurk");
        galacticDictionary.setRomanGalactic("I", "iurk");

        //Act
        result = numeralCalculator.galacticNumeralsToInteger(inputArray);

        //Assert
        assertEquals(1906, result);
    }
}