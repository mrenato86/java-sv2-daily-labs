package alldays;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MoviesRepository {

    private final DataSource dataSource;

    public MoviesRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public long saveMovie(String title, LocalDate release_date) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO movies (title,release_date) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, title);
            statement.setDate(2, Date.valueOf(release_date));
            statement.executeUpdate();
            return getGeneratedKey(statement);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot update: " + title, se);
        }
    }

    private long getGeneratedKey(PreparedStatement statement) throws SQLException {
        try (ResultSet rs = statement.getGeneratedKeys()) {
            if (rs.next()) {
                return rs.getLong(1);
            }
            throw new IllegalStateException("No generated key!");
        }
    }

    public List<Movie> findAllMovies() {
        List<Movie> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM movies");
             ResultSet resultSet = statement.executeQuery()
        ) {
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                LocalDate releaseDate = resultSet.getDate("release_date").toLocalDate();
                result.add(new Movie(id, title, releaseDate));
            }
            return result;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query!", se);
        }
    }

    public Optional<Movie> findMovieByTitle(String title) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT id,title,release_date FROM movies WHERE title = ?")
        ) {
            statement.setString(1, title);
            return getMovieFromResult(statement);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query!", se);
        }
    }

    private Optional<Movie> getMovieFromResult(PreparedStatement statement) throws SQLException {
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return Optional.of(new Movie(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getDate("release_date").toLocalDate()));
            }
            return Optional.empty();
        }
    }

    public void updateRatingForMovieId(long movieId, float rating){
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE movies SET avg_rating = ? WHERE id= ?")
        ) {
            statement.setFloat(1, rating);
            statement.setLong(2, movieId);
            statement.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot update!", se);
        }
    }

}
