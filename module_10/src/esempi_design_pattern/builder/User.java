package esempi_design_pattern.builder;

public class User {

    private String name;
    private String surname;
    private int age;

    protected User(UserBuilder ub) {
        this.name = ub.getName();
        this.surname = ub.getSurname();
        this.age = ub.getAge();
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

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
