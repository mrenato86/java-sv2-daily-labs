package day02;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BooksRepository {

    private final JdbcTemplate jdbcTemplate;

    public BooksRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insertBook(String title, String author, long price, long pieces) {
        jdbcTemplate.update("insert into books(title, author,price, pieces) values (?, ?, ?, ?)",
                title, author, price, pieces);
    }

    public long insertBookGetId(String title, String author, long price, long pieces) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
                    PreparedStatement ps =
                            connection.prepareStatement("insert into books(title, author,price, pieces) values (?, ?, ?, ?)",
                                    Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, title);
                    ps.setString(2, author);
                    ps.setLong(3, price);
                    ps.setLong(4, pieces);
                    return ps;
                }, keyHolder
        );
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    public List<Book> findBooksByAuthorPrefix(String prefix) {
        return jdbcTemplate.query("select * from books where author like ?",
                getBookRowMapper(),
                prefix + "%");
    }

    public Optional<Book> findBookById(long id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject("select * from books where id = ?",
                    getBookRowMapper(),
                    id));
        } catch (EmptyResultDataAccessException erdae) {
            return Optional.empty();
        }
    }

    private RowMapper<Book> getBookRowMapper() {
        return (rs, rowNum) -> new Book(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getLong("price"),
                rs.getLong("pieces"));
    }

    public void updateIncrementPieces(long id, long number) {
        jdbcTemplate.update("update books set pieces = (pieces + ?) where id = ?",
                number, id);
    }
}
