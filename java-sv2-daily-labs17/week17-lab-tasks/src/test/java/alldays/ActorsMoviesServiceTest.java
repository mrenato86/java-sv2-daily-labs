package alldays;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class ActorsMoviesServiceTest {

    ActorsRepository actorsRepository;
    MoviesRepository moviesRepository;
    ActorsMoviesRepository actorsMoviesRepository;

    ActorsMoviesService service;

    @BeforeEach
    void init() throws IOException, SQLException {
        Properties props = new Properties();
        try (InputStream is = Main.class.getResourceAsStream("/connection.properties")) {
            props.load(is);
        }

        MariaDbDataSource dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/movies-actors-test?useUnicode=true");
        dataSource.setUser(props.getProperty("un"));
        dataSource.setPassword(props.getProperty("pd"));

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        actorsRepository = new ActorsRepository(dataSource);
        moviesRepository = new MoviesRepository(dataSource);
        actorsMoviesRepository = new ActorsMoviesRepository(dataSource);
        service = new ActorsMoviesService(actorsRepository, moviesRepository, actorsMoviesRepository);

    }

    @Test
    void testInsertMovieWithActors() {
        service.insertMovieWithActors("Titanic", LocalDate.of(1997, 12, 11), List.of("L Dicaprio", "K Winslet"));
        service.insertMovieWithActors("Great Gatsby", LocalDate.of(2000, 10, 7), List.of("L Dicaprio", "Other"));

        assertTrue(actorsRepository.findActorByName("K Winslet").isPresent());
        assertEquals(1, actorsRepository.findActorsByPrefix("L Dicaprio").size());
        assertTrue(moviesRepository.findMovieByTitle("Great Gatsby").isPresent());
        assertEquals(2, moviesRepository.findAllMovies().size());
        assertEquals(4, actorsMoviesRepository.getNumberOfPairs());
    }

    @Test
    void testInsertMovieWithActorsException() {
        service.insertMovieWithActors("Titanic", LocalDate.of(1997, 12, 11), List.of("L Dicaprio", "K Winslet"));
        assertThrows(IllegalArgumentException.class,
                () -> service.insertMovieWithActors("Titanic", LocalDate.of(1997, 12, 11), List.of("L Dicaprio", "K Winslet"))
        );
    }
}