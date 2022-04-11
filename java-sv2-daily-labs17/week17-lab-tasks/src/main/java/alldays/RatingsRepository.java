package alldays;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RatingsRepository {

    private final DataSource dataSource;

    public RatingsRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean insertRating(long movieId, List<Integer> ratings) {
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            return executeInsertTransactions(connection, movieId, ratings);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert rating!", se);
        }
    }

    private boolean executeInsertTransactions(Connection connection, long movieId, List<Integer> ratings) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "insert into ratings (movie_id, rating) values (?, ?)")
        ) {
            for (int rating : ratings) {
                if (rating < 1 || rating > 5) {
                    connection.rollback();
                    return false;
                }
                statement.setLong(1, movieId);
                statement.setLong(2, rating);
                statement.executeUpdate();
            }
            connection.commit();
            return true;
        }
    }

    public float calculateAvgRatingForMovieId(long movieId) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT AVG(rating) FROM ratings WHERE movie_id = ?")
        ) {
            statement.setLong(1, movieId);
            return getAvgFromResult(statement);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query!", se);
        }
    }

    private float getAvgFromResult(PreparedStatement statement) throws SQLException {
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getFloat(1);
            }
            throw new IllegalStateException("No Average!");
        }
    }

}
