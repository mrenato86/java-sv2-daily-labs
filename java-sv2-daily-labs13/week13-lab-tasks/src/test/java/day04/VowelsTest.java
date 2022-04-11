package day04;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VowelsTest {

    @Test
    void testGetNumberOfVowels() {
        Map<Character, Integer> expected = Map.of('a', 2, 'e', 3, 'i', 2);
        assertEquals(expected, new Vowels().getNumberOfVowels("apple knife miracle"));
    }

}