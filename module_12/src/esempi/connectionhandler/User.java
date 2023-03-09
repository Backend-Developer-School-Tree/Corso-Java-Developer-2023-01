package esempi.connectionhandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class User implements Comparable<User> {

    private Integer id;
    private String name;
    private String lastName;

    public User(String name, String lastName) {
        this(null, name, lastName);
    }

    public User(Integer id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getLastName() { return lastName; }

    public static User fromResultSet(ResultSet rs) throws SQLException {
        return new User(rs.getInt("id"), rs.getString("nome"), rs.getString("cognome"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && name.equals(user.name) && lastName.equals(user.lastName);
    }

    @Override
    public int hashCode() { return Objects.hash(id, name, lastName); }

    @Override
    public int compareTo(User user) { return this.id.compareTo(user.id); }
}
