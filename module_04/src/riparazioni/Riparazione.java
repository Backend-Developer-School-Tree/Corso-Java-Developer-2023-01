package riparazioni;
public class Riparazione {

    private final String indirizzo;
    private int priorita;
    private StatoRiparazione stato;

    public Riparazione(String indirizzo, int priorita) {
        this.indirizzo = indirizzo;
        this.priorita = priorita;
        stato = StatoRiparazione.IN_ATTESA;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public int getPriorita() {
        return priorita;
    }

    public StatoRiparazione getStato() {
        return stato;
    }

    public void setStato(StatoRiparazione stato) {
        this.stato = stato;
    }

    public void setPriorita(int priorita) {
        this.priorita = priorita;
    }

    @Override
    public String toString(){
        return indirizzo+" "+priorita+" "+stato;
    }
}
