package esempi.connectionhandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    boolean insert(T entity) throws SQLException;

    boolean update(T entity) throws SQLException;

    boolean delete(int id) throws SQLException;

    Optional<T> get(int id) throws SQLException;

    List<T> getAll() throws SQLException;
}
