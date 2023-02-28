package esempi.builder;

public class Main {

    public static void main(String[] args) {
        UserBuilder ub = new UserBuilder()
                .name("Marco")
                .age(29);

        System.out.println(ub.getName() + " " + ub.getSurname());
        ub.surname("Adriani");
        System.out.println(ub.getName() + " " + ub.getSurname());

        User user = ub.build();
        System.out.println(user.getName() + " " + user.getSurname());
    }
}
