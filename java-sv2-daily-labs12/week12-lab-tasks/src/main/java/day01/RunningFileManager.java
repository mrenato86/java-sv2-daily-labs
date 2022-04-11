package day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class RunningFileManager {

    private static final String SEPARATOR = " km;";
    private static final int NUM_OF_HEADER = 1;

    public Running runningFromFile(Path path) {
        Running running = new Running();
        try (BufferedReader br = Files.newBufferedReader(path)) {
            int jumpedLine = 0;
            String line;
            while ((line = br.readLine()) != null) {
                if (jumpedLine == NUM_OF_HEADER) {
                    running.addRun(createRunFromLine(line));
                } else {
                    jumpedLine++;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("File reading error!", ioe);
        }
        return running;
    }

    private Run createRunFromLine(String line) {
        try {
            String[] parts = line.split(SEPARATOR);
            return new Run(Double.parseDouble(parts[0]), LocalDate.parse(parts[1]));
        } catch (ArrayIndexOutOfBoundsException | DateTimeParseException | IllegalArgumentException ex) {
            throw new IllegalArgumentException("Error during parse: " + ex.getMessage(), ex);
        }
    }

}
