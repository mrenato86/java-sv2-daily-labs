package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieServiceTest {

    List<Movie> testMovies = List.of(
            new Movie("Titanic", 180, List.of("DiCaprio", "Other")),
            new Movie("LOTR", 120, List.of("Wood", "Other")),
            new Movie("Westworld", 80, List.of("Hopkins", "Other"))
    );
    MovieService movieService = new MovieService();

    @BeforeEach
    void init() {
        testMovies.forEach(movieService::addMovie);
    }

    @Test
    void testFindMoviesWithActor() {
        List<Movie> result = movieService.findMoviesWithActor("DiCaprio");
        assertEquals("Titanic", testMovies.get(0).getTitle());
        assertEquals(1, result.size());
    }

    @Test
    void testGetLengthOfLongestMovie() {
        int result = movieService.getLengthOfLongestMovie();
        assertEquals(180, result);
    }
}