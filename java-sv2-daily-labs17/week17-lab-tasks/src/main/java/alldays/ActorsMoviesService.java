package alldays;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ActorsMoviesService {

    private ActorsRepository actorsRepository;
    private MoviesRepository moviesRepository;
    private ActorsMoviesRepository actorsMoviesRepository;

    public ActorsMoviesService(ActorsRepository actorsRepository, MoviesRepository moviesRepository, ActorsMoviesRepository actorsMoviesRepository) {
        this.actorsRepository = actorsRepository;
        this.moviesRepository = moviesRepository;
        this.actorsMoviesRepository = actorsMoviesRepository;
    }

    public void insertMovieWithActors(String title, LocalDate releaseDate, List<String> actorNames) {
        if (moviesRepository.findMovieByTitle(title).isPresent()) {
            throw new IllegalArgumentException("Movie already in database!");
        }
        long movieId = moviesRepository.saveMovie(title, releaseDate);
        for (String actual : actorNames) {
            Optional<Actor> found = actorsRepository.findActorByName(actual);
            long actorId = found.map(Actor::getId).orElseGet(() -> actorsRepository.saveActor(actual));
            actorsMoviesRepository.insertActorAndMovieId(actorId, movieId);
        }
    }
}
