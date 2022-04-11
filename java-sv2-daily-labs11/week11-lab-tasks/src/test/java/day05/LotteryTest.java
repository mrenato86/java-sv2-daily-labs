package day05;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LotteryTest {

    private boolean isAllDifferent(List<Integer> numbers) {
        for (int number : numbers) {
            if (!(numbers.indexOf(number) == numbers.lastIndexOf(number))) {
                return false;
            }
        }
        return true;
    }

    @Test
    void testStartLottery() {
        List<Integer> numbers = new Lottery(90, 5).startLottery();
        assertEquals(5, numbers.size());
        assertTrue(isAllDifferent(numbers));
    }
}