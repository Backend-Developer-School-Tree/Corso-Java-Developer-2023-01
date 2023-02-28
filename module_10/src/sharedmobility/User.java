package sharedmobility;

import java.time.LocalDate;
import java.util.Arrays;

public class User {
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

    public void setId(Integer id) { this.id = id; }

    public Integer getId() { return id; }

    public String getCsv() {
        return String.join(",", Arrays.asList(id.toString(), name, lastName, birthday.toString()));
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

    public static User parseCsv(String userCsv) {
        String[] values = userCsv.split(",");
        return new User(Integer.parseInt(values[0]), values[1], values[2], LocalDate.parse(values[3]));
    }
}
