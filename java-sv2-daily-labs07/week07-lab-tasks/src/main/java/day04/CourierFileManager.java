package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CourierFileManager {

    public Courier createCourierByFile(Path path) {
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("File reading error!", ioe);
        }
        return createCourierByLines(lines);
    }

    private Courier createCourierByLines(List<String> lines) {
        Courier courier = new Courier();
        for (String line : lines) {
            String[] parts = line.split(" ");
            courier.addRide(new Ride(
                    Integer.parseInt(parts[0]),
                    Integer.parseInt(parts[1]),
                    Integer.parseInt(parts[2])
            ));
        }
        return courier;
    }
}
