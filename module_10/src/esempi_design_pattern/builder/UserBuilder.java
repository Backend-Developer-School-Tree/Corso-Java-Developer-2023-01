package esempi_design_pattern.builder;

public class UserBuilder {

    private String name;
    private String surname;
    private int age;

    public UserBuilder() {}

    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder surname(String surname) {
        this.surname = surname;
        return this;
    }

    public UserBuilder age(int age) {
        this.age = age;
        return this;
    }

    public User build() {
        return new User(this);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }
}
