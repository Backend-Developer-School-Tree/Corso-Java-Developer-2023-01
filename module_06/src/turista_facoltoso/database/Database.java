package turista_facoltoso.database;

import turista_facoltoso.entities.*;
import turista_facoltoso.entities.users.Host;
import turista_facoltoso.entities.users.Utente;

import java.util.HashMap;
import java.util.HashSet;

public class Database {

    private static HashMap<Integer, Utente> utenti = new HashMap<>();
    private static HashMap<Integer, Abitazione> abitazioni = new HashMap<>();
    private static HashMap<Integer, Prenotazione> prenotazioni = new HashMap<>();
    private static HashMap<Integer, Feedback> feedbacks = new HashMap<>();

    private static HashMap<Integer, HashSet<Integer>> abitazioniHost = new HashMap<>();
    // mappa tra host e insieme delle prenotazioni su abitazioni dell'host
    private static HashMap<Integer, HashSet<Integer>> prenotazioniRicevute = new HashMap<>();
    // mappa tra utenti e prenotazioni effettuate dall'utente
    private static HashMap<Integer, HashSet<Integer>> prenotazioniEffettuate = new HashMap<>();
    // questa mappa è tra i codici delle abitazioni e l'insieme di tutte le prenotazioni effettuate su di essa
    private static HashMap<Integer, HashSet<Integer>> prenotazioniAbitazioni = new HashMap<>();

    // getter
    public static HashMap<Integer, Abitazione> getAbitazioni() { return abitazioni; }
    public static HashMap<Integer, Feedback> getFeedbacks() { return feedbacks; }
    public static HashMap<Integer, HashSet<Integer>> getAbitazioniHost() { return abitazioniHost; }
    public static HashMap<Integer, HashSet<Integer>> getPrenotazioniEffettuate() { return prenotazioniEffettuate; }
    public static HashMap<Integer, HashSet<Integer>> getPrenotazioniRicevute() { return prenotazioniRicevute; }
    public static HashMap<Integer, Prenotazione> getPrenotazioni() { return prenotazioni; }
    public static HashMap<Integer, Utente> getUtenti() { return utenti; }
    public static HashMap<Integer, HashSet<Integer>> getPrenotazioniAbitazioni() { return prenotazioniAbitazioni; }

    public static void addAbitazione(Abitazione ab) {
        abitazioni.put(ab.getId(), ab);
        prenotazioniAbitazioni.put(ab.getId(), new HashSet<>());
        int idHost = ab.getHost();
        if (abitazioniHost.containsKey(idHost)) {
            HashSet<Integer> abitazioniVecchie = abitazioniHost.get(idHost);
            abitazioniVecchie.add(ab.getId());
            abitazioniHost.put(idHost, abitazioniVecchie);
        }
        else {
            HashSet<Integer> abitazioniVecchie = new HashSet<>();
            abitazioniVecchie.add(ab.getId());
            abitazioniHost.put(idHost, abitazioniVecchie);
        }
    }

    public static void removeAbitazione(int idAbitazione) {
        Abitazione ab = abitazioni.get(idAbitazione); // prendo l'oggetto abitazione dal db
        int idHost = ab.getHost(); // prendo il codice host proprietario dell'abitazione
        HashSet<Integer> abitazioniDiQuestoHost = abitazioniHost.get(idHost); // prendo le abitazioni di questo host
        abitazioniDiQuestoHost.remove(idAbitazione); // rimuovo l'abitazione desiderata
        abitazioniHost.put(idHost, abitazioniDiQuestoHost); // aggiorno la mappa con il nuovo insieme senza l'abitazione eliminata
        abitazioni.remove(idAbitazione); // rimuovo l'abitazione anche dall'insieme di tutte le abitazioni
    }

    public static void addPrenotazione(Prenotazione pr) {
        prenotazioni.put(pr.getId(), pr);  // aggiorno la struttura dati prenotazioni
        int codiceAbitazionePrenotata = pr.getIdAbitazione(); // prendo l'id dell'abitazione prenotata
        Abitazione abitazionePrenotata = abitazioni.get(codiceAbitazionePrenotata); // prendo l'abitazione prenotata
        int codiceHost = abitazionePrenotata.getHost(); // ottengo il codice dell'host proprietario
        if (prenotazioniRicevute.containsKey(codiceHost)) { // aggiorno la struttura dati prenotazioniRicevute per l'host
            HashSet<Integer> prenotazioniPassate = prenotazioniRicevute.get(codiceHost);
            prenotazioniPassate.add(pr.getId());
            prenotazioniRicevute.put(codiceHost, prenotazioniPassate);
        }
        else {
            HashSet<Integer> prenotazioniPassate = new HashSet<>();
            prenotazioniPassate.add(pr.getId());
            prenotazioniRicevute.put(codiceHost, prenotazioniPassate);
        }
        int utente = pr.getIdUtente(); // prendo l'utente che ha effettuato la prenotazione
        if (prenotazioniEffettuate.containsKey(utente)) { // aggiorno la struttura dati prenotazioniEffettuate
            HashSet<Integer> prenotazioniUtente = prenotazioniEffettuate.get(utente);
            prenotazioniUtente.add(pr.getId());
            prenotazioniEffettuate.put(utente, prenotazioniUtente);
        }
        else {
            HashSet<Integer> prenotazioniUtente = new HashSet<>();
            prenotazioniUtente.add(pr.getId());
            prenotazioniEffettuate.put(utente, prenotazioniUtente);
        }
        // la aggiungo anche nella mappa abitazioni -> insieme di prenotazioni
        HashSet<Integer> prenotazioniAbitazione = prenotazioniAbitazioni.get(pr.getIdAbitazione());
        prenotazioniAbitazione.add(pr.getId());
        prenotazioniAbitazioni.put(abitazionePrenotata.getId(), prenotazioniAbitazione);
    }

    public static void removePrenotazione(Prenotazione pr) {
        prenotazioni.remove(pr.getId());
        // rimuovo la prenotazione dalle prenotazioni effettuate dagli utenti
        HashSet<Integer> prenotazioniUtente = prenotazioniEffettuate.get(pr.getIdUtente());
        prenotazioniUtente.remove(pr.getId());
        prenotazioniEffettuate.put(pr.getIdUtente(), prenotazioniUtente);
        // rimuovo la prenotazione dalle prenotazioni ricevute dall'host
        Abitazione ab = abitazioni.get(pr.getIdAbitazione());
        int codiceHost = ab.getHost();
        HashSet<Integer> prenotazioniHost = prenotazioniRicevute.get(codiceHost);
        prenotazioniHost.remove(ab.getId());
        prenotazioniRicevute.put(codiceHost, prenotazioniHost);
        HashSet<Integer> prenotazioniAbitazione = prenotazioniAbitazioni.get(pr.getIdAbitazione());
        prenotazioniAbitazione.remove(pr.getId());
        prenotazioniAbitazioni.put(pr.getIdAbitazione(), prenotazioniAbitazione);
    }

    public static void addFeedback(Feedback fb) { feedbacks.put(fb.getId(), fb); }
    public static void removeFeedback(Feedback fb) { feedbacks.remove(fb.getId()); }

}
