package day01;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Running {

    private final List<Run> running = new ArrayList<>();

    public void addRun(Run run) {
        if (run == null) {
            throw new IllegalArgumentException("Run can't be null!");
        }
        running.add(run);
    }

    public List<Run> getRunning() {
        return new ArrayList<>(running);
    }

    public double sumOfKmIn(int year, Month month) {
        double sum = 0;
        for (Run run : running) {
            LocalDate actualDate = run.getDate();
            if (actualDate.getYear() == year && actualDate.getMonth() == month) {
                sum += run.getKm();
            }
        }
        return sum;
    }
}
