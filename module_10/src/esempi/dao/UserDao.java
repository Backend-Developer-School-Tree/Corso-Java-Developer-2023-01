package esempi.dao;

import java.util.List;

public interface UserDao {
    boolean insert(User user);

    boolean update(User user);

    boolean delete(int id);

    User get(int id);

    List<User> getAll();
}
