package org.interpreter;

public interface IGalacticDictionary {
    int getIntegerValueForGalacticNumeral(String galacticNumeral);
    void setRomanGalactic(String romanNumeral, String galacticNumeral);
    boolean isExistingRomanNumeral(String givenNumeral);
    void setValuePerUnit(String unit, int value);
    int getValuePerUnit(String unit);
}
