package day01;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RunTest {

    @Test
    void testCreate() {
        Run run = new Run(20.1, LocalDate.of(2020, 2, 15));
        assertEquals(20.1, run.getKm());
        assertEquals(LocalDate.of(2020, 2, 15), run.getDate());
    }

    @Test
    void testCreateWrongKm() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new Run(-20., LocalDate.of(2020, 2, 15)));
        assertEquals("Illegal run data!", ex.getMessage());
    }

    @Test
    void testCreateWrongDate() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new Run(20.1, null));
        assertEquals("Illegal run data!", ex.getMessage());
    }

}