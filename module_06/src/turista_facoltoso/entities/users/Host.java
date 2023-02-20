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

    public void cambiaDisponibilita(int idAbitazione, LocalDate newInizio, LocalDate newFine) {
        Abitazione ab = Database.getAbitazioni().get(idAbitazione);
        ab.setInizioDisp(newInizio);
        ab.setFineDisp(newFine);
    }

    // questo metodo permette ad un host di rimuovere una prenotazione a carico di una sua abitazione
    public void removePrenotazioneByHost(int idPren) {
        Prenotazione pr = Database.getPrenotazioni().get(idPren);
        int idAbitazione = pr.getIdAbitazione();
        HashSet<Integer> abHost = Database.getAbitazioniHost().get(this.id);
        if (abHost.contains(idAbitazione)) { Database.removePrenotazione(pr); }
        else { System.out.println("Non puoi rimuovere una prenotazione non tua"); }
    }

    // questo metodo ritorna tutte le prenotazioni associate all'host
    public HashSet<Prenotazione> prenotazioniHost() {
        HashSet<Integer> idPrenotazioniRicevute = Database.getPrenotazioniRicevute().get(this.id);
        HashSet<Prenotazione> prenotazioniRicevute = new HashSet<>();
        for (Integer idPren : idPrenotazioniRicevute) {
            Prenotazione pr = Database.getPrenotazioni().get(idPren);
            prenotazioniRicevute.add(pr);
        }
        return prenotazioniRicevute;
    }

    // questo metodo ritorna tutte le prenotazioni di una certa abitazione dell'host
    public HashSet<Prenotazione> prenotazioniHost(int idAbitazione) {
        HashSet<Integer> idPrenotazioniRicevute = Database.getPrenotazioniRicevute().get(this.id);
        HashSet<Prenotazione> prenotazioniRicevute = new HashSet<>();
        for (Integer idPren : idPrenotazioniRicevute) {
            Prenotazione pr = Database.getPrenotazioni().get(idPren);
            if (pr.getIdAbitazione() == idAbitazione) {
                prenotazioniRicevute.add(pr);
            }
        }
        return prenotazioniRicevute;
    }

    // questo metodo ritorna la media totale di tutti i voti ricevuti dall'host in una qualsiasi prenotazione
    public double mediaHost() {
        HashSet<Integer> prenotazioniHost = Database.getPrenotazioniRicevute().get(this.id); // prendo le prenotazioni ricevute da questo host
        double media = 0.0;
        int totFeedback = 0;
        for (Integer codicePren : prenotazioniHost) {
            Prenotazione pr = Database.getPrenotazioni().get(codicePren);
            if (pr.getIdFeedback() == 0)  continue;
            media += Database.getFeedbacks().get(pr.getIdFeedback()).getVoto().getPunteggio();
            totFeedback++;
        }
        return media / totFeedback;
    }

    public double mediaAbitazione(int idAbitazione) {
        HashSet<Integer> prenotazioniHost = Database.getPrenotazioniRicevute().get(this.id); // prendo le prenotazioni ricevute da questo host
        double media = 0.0;
        int totFeedback = 0;
        for (Integer codicePren : prenotazioniHost) {
            Prenotazione pr = Database.getPrenotazioni().get(codicePren);
            if (pr.getIdFeedback() == 0 || pr.getIdAbitazione() != idAbitazione)  continue;
            media += Database.getFeedbacks().get(pr.getIdFeedback()).getVoto().getPunteggio();
            totFeedback++;
        }
        return media / totFeedback;
    }

}
