package esempi_design_pattern.observer;

public interface Observable {

    public void addObserver(Observer o);
    public void deleteObserver(Observer o);

}
