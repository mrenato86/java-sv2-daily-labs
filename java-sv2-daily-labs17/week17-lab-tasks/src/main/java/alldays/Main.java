package alldays;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        Properties props = new Properties();
        try (InputStream is = Main.class.getResourceAsStream("/connection.properties")) {
            props.load(is);
        } catch (IOException ioe) {
            throw new IllegalStateException("Properties read error!", ioe);
        }

        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/movies-actors?useUnicode=true");
            dataSource.setUser(props.getProperty("un"));
            dataSource.setPassword(props.getProperty("pd"));
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot reach DataBase!", se);
        }

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        ActorsRepository actorsRepository = new ActorsRepository(dataSource);
        System.out.println(actorsRepository.saveActor("Jack Doe"));
        actorsRepository.findActorsByPrefix("Ja").forEach(System.out::println);
        System.out.println(actorsRepository.findActorByName("Jack Doe"));
        System.out.println(actorsRepository.findActorByName("Not There"));

        MoviesRepository moviesRepository = new MoviesRepository(dataSource);
        moviesRepository.saveMovie("LOTR", LocalDate.of(2000, 12, 20));
        moviesRepository.findAllMovies().forEach(System.out::println);

        ActorsMoviesRepository actorsMoviesRepository = new ActorsMoviesRepository(dataSource);
        ActorsMoviesService service = new ActorsMoviesService(actorsRepository, moviesRepository, actorsMoviesRepository);
        service.insertMovieWithActors("Titanic", LocalDate.of(1997, 12, 11), List.of("L Dicaprio", "K Winslet"));
        service.insertMovieWithActors("Great Gatsby", LocalDate.of(2000, 10, 7), List.of("L Dicaprio", "Other"));

        RatingsRepository ratingsRepository = new RatingsRepository(dataSource);
        MovieRatingService movieRatingService = new MovieRatingService(moviesRepository, ratingsRepository);
        movieRatingService.addRating("Titanic", 1,5,2,4,5);
        movieRatingService.addRating("Great Gatsby", 1,/*6,*/4,5);
    }
}
