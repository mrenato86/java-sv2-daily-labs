package day0405;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileReaderTest {

    FileReader fileReader = new FileReader();

    @Test
    void testFindSmallestTemperatureSpread() {
        Path path = Path.of("src/main/resources/day04/datamunging/weather.dat");
        assertEquals(14, fileReader.findSmallestTemperatureSpread(path));
    }

    @Test
    void testFindSmallestDifference() {
        Path path = Path.of("src/main/resources/day04/datamunging/football.dat");
        assertEquals("Aston_Villa", fileReader.findSmallestDifference(path));
    }
}