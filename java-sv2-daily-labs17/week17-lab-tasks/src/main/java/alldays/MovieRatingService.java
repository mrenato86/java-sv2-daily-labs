package alldays;

import java.util.Arrays;
import java.util.Optional;

public class MovieRatingService {

    private MoviesRepository moviesRepository;
    private RatingsRepository ratingsRepository;

    public MovieRatingService(MoviesRepository moviesRepository, RatingsRepository ratingsRepository) {
        this.moviesRepository = moviesRepository;
        this.ratingsRepository = ratingsRepository;
    }

    public void addRating(String title, Integer... ratings) {
        Optional<Movie> movieToRate = moviesRepository.findMovieByTitle(title);
        if (movieToRate.isPresent()) {
            long movieId = movieToRate.get().getId();
            if (ratingsRepository.insertRating(movieId, Arrays.asList(ratings))) {
                float newRating = ratingsRepository.calculateAvgRatingForMovieId(movieId);
                moviesRepository.updateRatingForMovieId(movieId, newRating);
            }
        } else {
            throw new IllegalArgumentException("Cannot find movie: " + title);
        }
    }

}
