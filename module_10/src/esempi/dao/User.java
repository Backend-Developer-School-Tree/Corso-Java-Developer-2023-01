package esempi.dao;

import java.time.LocalDate;
import java.util.Objects;

public class User implements Comparable<User> {

    private Integer id;
    private String name;
    private String lastName;
    private LocalDate birthday;

    public User(Integer id, String name, String lastName, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    protected void setId(Integer id) { this.id = id; }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getLastName() { return lastName; }
    public LocalDate getBirthday() { return birthday; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && name.equals(user.name) && lastName.equals(user.lastName) && birthday.equals(user.birthday);
    }

    @Override
    public int hashCode() { return Objects.hash(id, name, lastName, birthday); }

    @Override
    public int compareTo(User user) { return this.id.compareTo(user.id); }
}
