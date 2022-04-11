package day02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {

    private final List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> findMoviesWithActor(String name) {
        return movies.stream()
                .filter(m -> m.getActors().contains(name))
                .collect(Collectors.toList());
    }

    public int getLengthOfLongestMovie() {
        return movies.stream()
                .mapToInt(Movie::getLength)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("No such movie."));
    }

}
