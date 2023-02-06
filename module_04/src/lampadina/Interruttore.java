package lampadina;

public class Interruttore {

    private Lampadina lampadina;

    public Interruttore(Lampadina lampadina) {
        this.lampadina = lampadina;
    }

    public boolean click(){
        return lampadina.click();
    }
}
