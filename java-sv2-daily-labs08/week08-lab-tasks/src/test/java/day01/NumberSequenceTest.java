package day01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberSequenceTest {

    List<Integer> testNumbers = List.of(10, 7, 3, 6, -1, 8, 1);

    @Test
    void testCreateWithList() {
        NumberSequence numberSequence = new NumberSequence(testNumbers);

        assertEquals(testNumbers, numberSequence.getNumbers());
    }

    boolean checkNumbers(List<Integer> numbers, int min, int max) {
        for (int number : numbers) {
            if (min > number || number > max) {
                return false;
            }
        }
        return true;
    }

    @Test
    void testCreateWithRandom() {
        NumberSequence numberSequence = new NumberSequence(7, -1, 10);

        assertEquals(7, numberSequence.getNumbers().size());
        assertTrue(checkNumbers(numberSequence.getNumbers(), -1, 10));
    }

    @Test
    void testCloseToAverage() {
        NumberSequence numberSequence = new NumberSequence(testNumbers);
        int valueToTest = 3;
        List<Integer> expected = List.of(7, 3, 6);
        assertEquals(expected, numberSequence.closeToAverage(valueToTest));
    }

    @Test
    void testCloseToAverageException() {
        IllegalStateException ise = assertThrows(IllegalStateException.class,
                () -> new NumberSequence(null).closeToAverage(3));
        assertEquals("Cannot calculate average for empty list!", ise.getMessage());

        ise = assertThrows(IllegalStateException.class,
                () -> new NumberSequence(new ArrayList<>()).closeToAverage(3));
        assertEquals("Cannot calculate average for empty list!", ise.getMessage());
    }
}