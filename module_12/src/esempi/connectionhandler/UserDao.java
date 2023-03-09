package esempi.connectionhandler;

import java.sql.SQLException;
import java.util.List;

public interface UserDao extends Dao<User> {
    List<User> getByLastName(String lastName) throws SQLException;
}

/*
public interface UserDao {
    boolean insert(User user) throws SQLException;

    boolean update(User user) throws SQLException;

    boolean delete(int id) throws SQLException;

    User get(int id) throws SQLException;
    List<User> getByLastName(String lastName) throws SQLException;
    List<User> getAll() throws SQLException;
}
 */
