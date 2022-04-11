package day01;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class RunningTest {

    Running running = new Running();

    @Test
    void testCreate() {
        Running running = new Running();
        assertEquals(0, running.getRunning().size());
    }

    @Test
    void testAddRun() {
        Run run = new Run(20.1, LocalDate.of(2020, 2, 15));
        running.addRun(run);

        assertEquals(1, running.getRunning().size());
        assertSame(run, running.getRunning().get(0));
    }

    @Test
    void testAddRunWrongRun() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> running.addRun(null));
        assertEquals("Run can't be null!", ex.getMessage());
    }

    @Test
    void testSumOfKmIn() {
        running.addRun(new Run(20.1, LocalDate.of(2020, 2, 15)));
        running.addRun(new Run(10.1, LocalDate.of(2020, 2, 11)));
        running.addRun(new Run(10.1, LocalDate.of(2022, 1, 11)));
        assertEquals(30.2, running.sumOfKmIn(2020, Month.FEBRUARY), 0.001);
        assertEquals(0., running.sumOfKmIn(2020, Month.DECEMBER));
    }

}