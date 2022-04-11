package alldays;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class MoviesRepositoryTest {

    MoviesRepository moviesRepository;

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

        moviesRepository = new MoviesRepository(dataSource);
    }

    @Test
    void testSaveMovieAndFindMovieByName() {
        long id = moviesRepository.saveMovie("Titanic", LocalDate.of(1997, 12, 11));
        Optional<Movie> queried = moviesRepository.findMovieByTitle("Titanic");
        Optional<Movie> empty = moviesRepository.findMovieByTitle("Not There");

        assertEquals(1, id);
        assertTrue(queried.isPresent());
        assertEquals("Titanic", queried.get().getTitle());
        assertFalse(empty.isPresent());
    }

    @Test
    void testFindAllMovies() {
        moviesRepository.saveMovie("Titanic", LocalDate.of(1997, 12, 11));
        moviesRepository.saveMovie("LOTR", LocalDate.of(2000, 12, 20));

        assertEquals(2, moviesRepository.findAllMovies().size());
    }
}