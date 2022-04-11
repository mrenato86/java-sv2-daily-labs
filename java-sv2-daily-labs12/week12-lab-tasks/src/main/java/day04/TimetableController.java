package day04;

import java.nio.file.Path;

public class TimetableController {

    public static void main(String[] args) {
        TimetableService ts = new TimetableService(Path.of("src/main/resources/day04/beosztas.txt"));
        System.out.println(ts.getElements().size());
        System.out.println(ts.sumOfLessonsForTeacher("Albatrosz Aladin"));
    }
}
