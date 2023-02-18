package turista_facoltoso.entities;

import turista_facoltoso.enumerators.Voto;

public class Feedback {

    // attributi statici
    private static int idTot = 0;

    // attributi
    private int id;
    private String titolo;
    private String testo;
    private Voto voto;
    private int idPrenotazione;

    // costruttore
    public Feedback(String titolo, String testo, Voto voto, int idPrenotazione) {
        this.id = idTot++;
        this.titolo = titolo;
        this.testo = testo;
        this.voto = voto;
        this.idPrenotazione = idPrenotazione;
    }

    // getters
    public int getId() { return id; }
    public String getTitolo() { return titolo; }
    public String getTesto() { return testo; }
    public Voto getVoto() { return voto; }
    public int getIdPrenotazione() { return idPrenotazione; }

    // setters
    public void setTitolo(String titolo) { this.titolo = titolo; }
    public void setTesto(String testo) { this.testo = testo; }
    public void setVoto(Voto voto) { this.voto = voto; }
    public void setIdPrenotazione(int idPrenotazione) { this.idPrenotazione = idPrenotazione; }
}
