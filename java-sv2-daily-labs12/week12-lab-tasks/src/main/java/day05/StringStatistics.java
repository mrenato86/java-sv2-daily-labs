package day05;

import java.util.HashMap;
import java.util.Map;

public class StringStatistics {

    public Map<Character, Integer> getStatistics(String input) {
        if(input == null){
            throw new IllegalArgumentException("Input string must not be null!");
        }
        Map<Character, Integer> statistics = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char actual = input.charAt(i);
            if (statistics.containsKey(actual)) {
                statistics.put(actual, statistics.get(actual) + 1);
            } else {
                statistics.put(actual, 1);
            }
        }
        return statistics;
    }

}
