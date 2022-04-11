package day0405.refactored;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeamsFileReaderTest {

    @Test
    void testFindSmallestDifference() {
        assertEquals("Aston_Villa", new TeamsFileReader().findSmallestDifferenceName());
    }
}