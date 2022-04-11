package day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TimetableService {

    private final List<TimetableElement> elements = new ArrayList<>();

    public TimetableService(Path path) {
        fillFromFile(path);
    }

    public List<TimetableElement> getElements() {
        return elements;
    }

    private void fillFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                elements.add(new TimetableElement(line, br.readLine(), br.readLine(), Integer.parseInt(br.readLine())));
            }
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException("File structure error: " + iae.getMessage(), iae);
        } catch (IOException ioe) {
            throw new IllegalStateException("File reading error!", ioe);
        }
    }

    public int sumOfLessonsForTeacher(String name) {
        int sum = 0;
        for (TimetableElement element : elements) {
            if (element.getTeacherName().equals(name)) {
                sum += element.getNumberOfLessons();
            }
        }
        return sum;
    }

}
