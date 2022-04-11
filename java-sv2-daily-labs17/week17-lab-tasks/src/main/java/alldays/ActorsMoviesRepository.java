package alldays;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorsMoviesRepository {

    private final DataSource dataSource;

    public ActorsMoviesRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertActorAndMovieId(long actorId, long movieId) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "insert into actors_movies (actor_id, movie_id) values (? ,?)")
        ) {
            statement.setLong(1, actorId);
            statement.setLong(2, movieId);
            statement.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert!", se);
        }
    }

    public long getNumberOfPairs() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "Select count(*) from actors_movies");
             ResultSet resultSet = statement.executeQuery()
        ) {
            if (resultSet.next()) {
                return resultSet.getLong(1);
            }
            return 0;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert!", se);
        }
    }

}
