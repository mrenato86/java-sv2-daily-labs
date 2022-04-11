package day02;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        Properties props = new Properties();
        try (InputStream is = Main.class.getResourceAsStream("/connection.properties")) {
            props.load(is);
        } catch (IOException ioe) {
            throw new IllegalStateException("Invalid properties file!", ioe);
        }

        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/bookstore?useUnicode=true");
            dataSource.setUser(props.getProperty("un"));
            dataSource.setPassword(props.getProperty("pd"));
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot reach database!", se);
        }

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        BooksRepository booksRepository = new BooksRepository(dataSource);

        booksRepository.insertBook("Vuk", "Fekete István", 3400, 10);
        long id = booksRepository.insertBookGetId("Téli berek", "Fekete István", 3600, 8);
        System.out.println(id);
        System.out.println(booksRepository.findBooksByAuthorPrefix("f"));

        booksRepository.updateIncrementPieces(1, 30);
        System.out.println(booksRepository.findBooksByAuthorPrefix("f"));

        System.out.println(booksRepository.findBookById(2));
    }
}
