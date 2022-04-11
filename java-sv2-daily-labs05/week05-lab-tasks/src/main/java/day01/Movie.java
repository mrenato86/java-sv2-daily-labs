package day01;

import java.time.LocalDateTime;
import java.util.List;

public class Movie {

    private String name;
    private List<LocalDateTime> dateTimes;

    public Movie(String name, List<LocalDateTime> dateTimes) {
        this.name = name;
        this.dateTimes = dateTimes;
    }

    public String getName() {
        return name;
    }

    public List<LocalDateTime> getDateTimes() {
        return dateTimes;
    }
}
