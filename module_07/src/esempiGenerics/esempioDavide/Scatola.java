public class Scatola<T> {

    private T oggetto;

    private String miaStringa;

    public Scatola(T oggetto) {
        this.oggetto = oggetto;
    }

    public Scatola(T oggetto, String miaStringa) {
        this.oggetto = oggetto;
        this.miaStringa = miaStringa;
    }

    public T getOggetto() {
        return oggetto;
    }

    public void setOggetto(T oggetto) {
        this.oggetto = oggetto;
    }

    public String getMiaStringa() {
        return miaStringa;
    }

    public void setMiaStringa(String miaStringa) {
        this.miaStringa = miaStringa;
    }

    public String getDescrizioneOggetto() {
        return "L'oggetto è di tipo: " + this.oggetto.getClass().getName();
    }

    @Override
    public String toString() {
        return "Scatola [oggetto=" + oggetto + ", miaStringa=" + miaStringa + "]";
    }

}
