package org.interpreter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GalacticDictionaryTest {
    private IGalacticDictionary galacticDictionary;

    @BeforeEach
    void arrange() {
        //Getters and Setters for valuesPerUnit are not necessary
        galacticDictionary = new GalacticDictionary();
    }

    @Test
    void getIntegerValueForGalacticNumeral() {
        //Arrange
        galacticDictionary.setRomanGalactic("I","glob");
        galacticDictionary.setRomanGalactic("V","prok");
        galacticDictionary.setRomanGalactic("X","pish");
        galacticDictionary.setRomanGalactic("L","tegj");
        galacticDictionary.setRomanGalactic("C","crok");
        galacticDictionary.setRomanGalactic("D","drok");
        galacticDictionary.setRomanGalactic("M","mrok");

        //Act
        int valueForI = galacticDictionary.getIntegerValueForGalacticNumeral("glob");
        int valueForV = galacticDictionary.getIntegerValueForGalacticNumeral("prok");
        int valueForX = galacticDictionary.getIntegerValueForGalacticNumeral("pish");
        int valueForL = galacticDictionary.getIntegerValueForGalacticNumeral("tegj");
        int valueForC = galacticDictionary.getIntegerValueForGalacticNumeral("crok");
        int valueForD = galacticDictionary.getIntegerValueForGalacticNumeral("drok");
        int valueForM = galacticDictionary.getIntegerValueForGalacticNumeral("mrok");

        int invalidValue = galacticDictionary.getIntegerValueForGalacticNumeral("brul");

        //Assert
        assertEquals(1, valueForI);
        assertEquals(5, valueForV);
        assertEquals(10, valueForX);
        assertEquals(50, valueForL);
        assertEquals(100, valueForC);
        assertEquals(500, valueForD);
        assertEquals(1000, valueForM);
        assertEquals(0, invalidValue);
    }

    @Test
    void setRomanGalactic() {
        //Arrange
        String validNumeral = "V";
        String validLowerCaseNumeral = "c";
        String invalidNumeral = "r";

        //Act
        galacticDictionary.setRomanGalactic(validNumeral,"vrok");
        galacticDictionary.setRomanGalactic(validLowerCaseNumeral,"crok");
        galacticDictionary.setRomanGalactic(invalidNumeral,"rrok");

        //Assert
        assertEquals(5, galacticDictionary.getIntegerValueForGalacticNumeral("vrok"));
        assertEquals(100, galacticDictionary.getIntegerValueForGalacticNumeral("crok"));
        assertEquals(0, galacticDictionary.getIntegerValueForGalacticNumeral("rrok"));
    }
}