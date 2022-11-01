package org.interpreter;

import java.util.HashMap;
import java.util.Map;

public class GalacticDictionary implements IGalacticDictionary {
    private Map<String, String> romanToGalactic;
    private Map<String, Integer> romanNumeralValues;

    public GalacticDictionary() {
        romanToGalactic = new HashMap<>();
        initializeRomanToGalacticMap();

        romanNumeralValues = new HashMap<>();
        initializeRomanNumerals();
    }

    private void initializeRomanToGalacticMap() {
        romanToGalactic.put("I", null);
        romanToGalactic.put("V", null);
        romanToGalactic.put("X", null);
        romanToGalactic.put("L", null);
        romanToGalactic.put("C", null);
        romanToGalactic.put("D", null);
        romanToGalactic.put("M", null);
    }
    private void initializeRomanNumerals() {
        romanNumeralValues.put("I", 1);
        romanNumeralValues.put("V", 5);
        romanNumeralValues.put("X", 10);
        romanNumeralValues.put("L", 50);
        romanNumeralValues.put("C", 100);
        romanNumeralValues.put("D", 500);
        romanNumeralValues.put("M", 1000);
    }

    public int getIntegerValueForGalacticNumeral(String galacticNumeral) {
        for (Map.Entry<String, String> entry : romanToGalactic.entrySet()) {
            if (galacticNumeral.equals(entry.getValue())) {
                int integerValue = romanNumeralValues.get(entry.getKey());
                return integerValue;
            }
        }
        return 0;
    }

    public void setRomanGalactic(String romanNumeral, String galacticNumeral) {
        String upperCaseRoman = romanNumeral.toUpperCase();
        if (romanToGalactic.containsKey(upperCaseRoman)) {
            romanToGalactic.put(upperCaseRoman, galacticNumeral);
        }
    }
}
