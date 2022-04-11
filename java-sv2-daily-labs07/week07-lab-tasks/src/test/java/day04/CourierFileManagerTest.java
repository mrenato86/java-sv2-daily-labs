package day04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CourierFileManagerTest {

    @Test
    void testCreateCourierByFile() {
        Path path = Path.of("src/test/resources/day04/courier.txt");
        Courier courier = new CourierFileManager().createCourierByFile(path);

        String expected = "1 1 12\n1 2 11\n2 1 10\n4 1 19\n4 2 5\n4 3 9";
        assertEquals(expected, courier.toString());
    }
}