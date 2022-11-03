package org.interpreter.GalacticDictionary;

public interface IGalacticDictionary {
    int getIntegerValueForGalacticNumeral(String galacticNumeral);
    void setRomanGalactic(String romanNumeral, String galacticNumeral);
    boolean isExistingRomanNumeral(String givenNumeral);
    void setValuePerUnit(String unit, float value);
    float getValuePerUnit(String unit);
}
