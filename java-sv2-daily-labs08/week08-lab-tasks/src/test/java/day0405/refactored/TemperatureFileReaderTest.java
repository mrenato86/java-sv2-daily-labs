package day0405.refactored;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemperatureFileReaderTest {

    @Test
    void testFindSmallestTemperatureSpread() {
        assertEquals("14", new TemperatureFileReader().findSmallestDifferenceName());
    }

}