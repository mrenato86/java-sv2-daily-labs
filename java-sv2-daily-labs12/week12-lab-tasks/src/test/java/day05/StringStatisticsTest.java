package day05;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringStatisticsTest {

    StringStatistics stringStatistics = new StringStatistics();

    @Test
    void testGetStatistics() {
        Map<Character, Integer> expected = Map.of('a', 3, 'f', 1, 'l', 1, 'm', 1);
        assertEquals(expected, stringStatistics.getStatistics("almafa"));
    }

}