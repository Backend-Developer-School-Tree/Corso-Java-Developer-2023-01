package esempi.builder;

public class Main {

    public static void main(String[] args) {
        User user = new UserBuilder().name("Marco").age(29).build();
        System.out.println(user.getName() + " " + user.getSurname());
        user.setSurname("Adriani");
        System.out.println(user.getName() + " " + user.getSurname());


    }
}
