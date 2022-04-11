package day04;

import java.util.Map;
import java.util.TreeMap;

public class Vowels {

    private static final String VOWELS = "aAeEiIoOuU";

    public Map<Character, Integer> getNumberOfVowels(String text) {
        Map<Character, Integer> numOfVowels = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            char actual = text.charAt(i);
            if (VOWELS.indexOf(actual) > -1) {
                int numberToPut = numOfVowels.containsKey(actual) ? numOfVowels.get(actual) + 1 : 1;
                numOfVowels.put(actual, numberToPut);
            }
        }
        return numOfVowels;
    }

}
