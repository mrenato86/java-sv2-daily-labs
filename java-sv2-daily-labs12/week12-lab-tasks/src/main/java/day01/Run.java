package day01;

import java.time.LocalDate;
import java.util.Objects;

public class Run {

    private double km;
    private LocalDate date;

    public Run(double km, LocalDate date) {
        if (km <= 0 || date == null) {
            throw new IllegalArgumentException("Illegal run data!");
        }
        this.km = km;
        this.date = date;
    }

    public double getKm() {
        return km;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Run run = (Run) o;
        return Double.compare(run.km, km) == 0 && Objects.equals(date, run.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(km, date);
    }
}
