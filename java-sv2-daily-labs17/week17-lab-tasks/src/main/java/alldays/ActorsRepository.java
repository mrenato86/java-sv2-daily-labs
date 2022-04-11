package alldays;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ActorsRepository {

    private final DataSource dataSource;

    public ActorsRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public long saveActor(String name) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO actors (actor_name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, name);
            statement.executeUpdate();
            return getGeneratedKey(statement);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot update: " + name, se);
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

    public List<String> findActorsByPrefix(String prefix) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT actor_name FROM actors WHERE actor_name LIKE ?")
        ) {
            statement.setString(1, prefix + '%');
            return getAllResults(statement);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query!", se);
        }
    }

    private List<String> getAllResults(PreparedStatement statement) throws SQLException {
        List<String> result = new ArrayList<>();
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                result.add(resultSet.getString("actor_name"));
            }
        }
        return result;
    }

    public Optional<Actor> findActorByName(String name) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT id,actor_name FROM actors WHERE actor_name = ?")
        ) {
            statement.setString(1, name);
            return getActorFromResult(statement);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query!", se);
        }
    }

    private Optional<Actor> getActorFromResult(PreparedStatement statement) throws SQLException {
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return Optional.of(new Actor(resultSet.getLong("id"), resultSet.getString("actor_name")));
            }
            return Optional.empty();
        }
    }
}
