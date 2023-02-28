package esempi.observer;

public class User implements Observer {

    private ConnectionNotifier connectionNotifier;
    private String name;
    private String surname;

    public User(String name, String surname, ConnectionNotifier connectionNotifier) {
        this.name = name;
        this.surname = surname;
        connectionNotifier.addObserver(this);
    }


    @Override
    public void notifyMe(Observable o, String message) {
        if (message.contains("OK") && message.contains(this.name + " " + this.surname)) {
            System.out.println("connessione stabilita");
        }
    }
}
