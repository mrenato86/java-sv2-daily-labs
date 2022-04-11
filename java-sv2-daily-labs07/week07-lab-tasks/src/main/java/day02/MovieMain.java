package day02;

import java.nio.file.Paths;

public class MovieMain {

    public static void main(String[] args) {
        MovieService movieService = new MovieService(Paths.get("src/main/resources/day02/movies.csv"));
        System.out.println(movieService.getMovies());
    }
}
