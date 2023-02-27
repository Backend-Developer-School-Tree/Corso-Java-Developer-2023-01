package esempi_design_pattern.builder;

import esempi_design_pattern.builder.User;
import esempi_design_pattern.builder.UserBuilder;
import esempi_design_pattern.observer.ConnectionNotifier;

public class Main {

    public static void main(String[] args) {
        User user = new UserBuilder().name("Marco").age(29).build();
        System.out.println(user.getName() + " " + user.getSurname());
        user.setSurname("Adriani");
        System.out.println(user.getName() + " " + user.getSurname());


    }
}
