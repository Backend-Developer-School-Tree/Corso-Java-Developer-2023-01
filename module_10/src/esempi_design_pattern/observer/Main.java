package esempi_design_pattern.observer;

public class Main {

    public static void main(String[] args) {
        ConnectionNotifier connectionNotifier = new ConnectionNotifier();
        User user = new User("Marco", "Adriani", connectionNotifier);
        System.out.println(connectionNotifier.getObservers());
    }

}
