package alldays;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class ActorsRepositoryTest {

    ActorsRepository actorsRepository;

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
    }

    @Test
    void testSaveActorAndFindActorByName() {
        long id = actorsRepository.saveActor("Jack Doe");
        Optional<Actor> queried = actorsRepository.findActorByName("Jack Doe");
        Optional<Actor> empty = actorsRepository.findActorByName("Not There");

        assertEquals(1, id);
        assertTrue(queried.isPresent());
        assertEquals("Jack Doe", queried.get().getName());
        assertFalse(empty.isPresent());
    }

    @Test
    void testFindActorsByPrefix() {
        actorsRepository.saveActor("Jack Doe");
        actorsRepository.saveActor("John Doe");
        actorsRepository.saveActor("Pete Doe");

        assertEquals(2, actorsRepository.findActorsByPrefix("J").size());
    }

}