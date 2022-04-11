package day01;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RunningFileManagerTest {

    RunningFileManager runningFileManager = new RunningFileManager();

    @Test
    void testRunningFromFile() {
        Path path = Path.of("src/test/resources/day01/running.csv");
        Run testRun = new Run(7.1, LocalDate.of(2021, 11, 28));

        Running result = runningFileManager.runningFromFile(path);
        assertEquals(7, result.getRunning().size());
        assertEquals(testRun, result.getRunning().get(0));

        assertEquals(41.2, result.sumOfKmIn(2021, Month.DECEMBER), 0.001);
        assertEquals(25.9, result.sumOfKmIn(2022, Month.JANUARY), 0.001);
        assertEquals(0., result.sumOfKmIn(2022, Month.FEBRUARY));
    }

}