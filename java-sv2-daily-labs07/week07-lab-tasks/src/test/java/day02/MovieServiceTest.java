package day02;

import org.junit.jupiter.api.Test;

import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MovieServiceTest {

    @Test
    void testCreate() {
        Path path = Paths.get("src/test/resources/day02/movies.csv");
        MovieService movieService = new MovieService(path);
        assertEquals(5, movieService.getMovies().size());
        assertEquals("Star Wars", movieService.getMovies().get(2).getTitle());
        assertEquals(1977, movieService.getMovies().get(2).getReleaseDate());
        assertEquals("George Lucas", movieService.getMovies().get(2).getProducer());
    }

    @Test
    void testCreateNoFile() {
        Path path = Paths.get("src/test/resources/day02/NoMovies.csv");
        IllegalStateException ise = assertThrows(IllegalStateException.class, () -> new MovieService(path));
        assertEquals("File reading error: " + path, ise.getMessage());
        assertEquals(NoSuchFileException.class, ise.getCause().getClass());
    }

}