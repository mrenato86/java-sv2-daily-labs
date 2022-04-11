package day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MovieService {

    private List<Movie> movies;

    public MovieService(Path filePath) {
        this.movies = readMovies(readFile(filePath));
    }

    private List<String> readFile(Path filePath) {
        try {
            return Files.readAllLines(filePath);
        } catch (IOException ioe) {
            throw new IllegalStateException("File reading error: " + filePath, ioe);
        }
    }

    private List<Movie> readMovies(List<String> lines) {
        List<Movie> movies = new ArrayList<>();
        for (String line : lines) {
            String[] tmp = line.split(";");
            movies.add(new Movie(tmp[0], Integer.parseInt(tmp[1]), tmp[2]));
        }
        return movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
