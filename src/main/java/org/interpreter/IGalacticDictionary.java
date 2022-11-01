package org.interpreter;

public interface IGalacticDictionary {
    int getIntegerValueForGalacticNumeral(String galacticNumeral);
    void setRomanGalactic(String romanNumeral, String galacticNumeral);
    void setValuePerUnit(String unit, int value);
    int getValuePerUnit(String unit);
}
