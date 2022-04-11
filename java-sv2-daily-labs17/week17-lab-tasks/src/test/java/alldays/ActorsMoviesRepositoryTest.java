package alldays;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ActorsMoviesRepositoryTest {

    ActorsMoviesRepository actorsMoviesRepository;

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

        actorsMoviesRepository = new ActorsMoviesRepository(dataSource);
    }


    @Test
    void testInsertActorAndMovieIdAndGetNumberOfPairs() {
        actorsMoviesRepository.insertActorAndMovieId(5, 3);
        actorsMoviesRepository.insertActorAndMovieId(4, 2);

        assertEquals(2, actorsMoviesRepository.getNumberOfPairs());
    }
}