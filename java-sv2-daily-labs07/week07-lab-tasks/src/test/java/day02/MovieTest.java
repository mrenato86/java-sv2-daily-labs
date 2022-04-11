package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieTest {

    @Test
    void testCreate() {
        Movie movie = new Movie("Jurassic park", 1993, "Steven Spielberg");
        assertEquals("Jurassic park", movie.getTitle());
        assertEquals(1993, movie.getReleaseDate());
        assertEquals("Steven Spielberg", movie.getProducer());
    }

}