package turista_facoltoso.enumerators;

public enum Voto {

    ONE(1, "Fa schifo"), TWO(2, "Un mezzo schifo"),
    THREE(3, "discreto"), FOUR(4, "buono"), FIVE(5, "da paura");

    private int punteggio;
    private String descrizione;

    Voto(int punteggio, String descrizione) {
        this.punteggio = punteggio;
        this.descrizione = descrizione;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public String getDescrizione() {
        return descrizione;
    }

}
