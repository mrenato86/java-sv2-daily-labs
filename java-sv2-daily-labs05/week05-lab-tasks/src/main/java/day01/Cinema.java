package day01;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cinema {

    private List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<String> findMovieByTime(LocalDateTime freeTime) {
        List<String> titles = new ArrayList<>();
        for (Movie movie : movies) {
            if (movieContainsTime(movie, freeTime)) {
                titles.add(movie.getName());
            }
        }
        return titles;
    }

    private boolean movieContainsTime(Movie movie, LocalDateTime freeTime) {
        for (LocalDateTime time : movie.getDateTimes()) {
            if (freeTime.isEqual(time)) {
                return true;
            }
        }
        return false;
    }
}
