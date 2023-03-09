package esempi.connectionhandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoSql implements UserDao {

    @Override
    public boolean insert(User user) throws SQLException {
        String query = "INSERT INTO utente (nome, cognome) VALUES (?, ?);";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query))
        {
            ps.setString(1, user.getName());
            ps.setString(2, user.getLastName());
            int insertedCount = ps.executeUpdate();

            return insertedCount > 0;
        }
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Optional<User> get(int id) throws SQLException {
        Optional<User> user = Optional.empty();

        String query = "SELECT * FROM utente WHERE id = ?;";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query))
        {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) user = Optional.of(User.fromResultSet(rs));
        }

        return user;
    }

    @Override
    public List<User> getByLastName(String lastName) throws SQLException {
        return null;
    }

    @Override
    public List<User> getAll() throws SQLException {
        List<User> users = new ArrayList<>();

        String query = "SELECT * FROM utente;";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query);
             ResultSet rs = ps.executeQuery())
        {
            while (rs.next()) users.add(User.fromResultSet(rs));
        }

        return users;
    }

    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDaoSql();

        System.out.println(userDao.get(1));

        System.out.println(userDao.getAll());

        userDao.insert(new User("Luigi", "Mario"));

        System.out.println(userDao.getAll());

        userDao.update(new User(4, "Mario", "Mario"));

        System.out.println(userDao.get(4));

        userDao.delete(4);

        System.out.println(userDao.get(4));
    }
}
