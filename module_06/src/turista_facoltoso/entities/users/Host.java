package turista_facoltoso.entities.users;

import turista_facoltoso.database.Database;
import turista_facoltoso.entities.Abitazione;
import turista_facoltoso.entities.Prenotazione;
import turista_facoltoso.entities.users.Utente;

import java.time.LocalDate;
import java.util.HashSet;

public class Host extends Utente {

    // attributi statici
    private static int codiceTot = 0;

    // attributi
    private int codiceHost;
    private HashSet<Integer> abitazioni; // ---> i codici delle abitazioni possedute dall'host

    public Host(String nome, String cognome, String email, String indirizzo) {
        super(nome, cognome, email, indirizzo);
        codiceHost = codiceTot++;
    }

    // getter
    public int getCodiceHost() { return codiceHost; }
    public HashSet<Integer> getAbitazioni() { return abitazioni; }

    // setter
    public void setCodiceHost(int codiceHost) { this.codiceHost = codiceHost; }
    public void setAbitazioni(HashSet<Integer> abitazioni) { this.abitazioni = abitazioni; }

    // metodi
    public void addAbitazione(String nome, String indirizzo, double prezzo, int nLocali, int nPostiLetto,
                              int piano, LocalDate inizioDisp, LocalDate fineDisp) {
        Abitazione ab = new Abitazione(nome, indirizzo, prezzo, nLocali, nPostiLetto, piano, inizioDisp, fineDisp, id);
        Database.addAbitazione(ab);
    }

    public void removeAbitazione(int idAbitazione) { Database.removeAbitazione(idAbitazione); }

    public void cambiaDisponibilita() {}

    // questo metodo permette ad un host di rimuovere una prenotazione a carico di una sua abitazione
    public void removePrenotazioneByHost(int idPren) {
        Prenotazione pr = Database.getPrenotazioni().get(idPren);
        int idAbitazione = pr.getIdAbitazione();
        HashSet<Integer> abHost = Database.getAbitazioniHost().get(this.id);
        if (abHost.contains(idAbitazione)) { Database.removePrenotazione(pr); }
        else { System.out.println("Non puoi rimuovere una prenotazione non tua"); }
    }

    public HashSet<Prenotazione> prenotazioniHost() { return null; }

    public HashSet<Prenotazione> prenotazioniHost(int idAbitazione) { return null; }

    public double mediaHost() { return 0.0; }

    public double mediaAbitazione(int idAbitazione) { return 0.0; }

}
