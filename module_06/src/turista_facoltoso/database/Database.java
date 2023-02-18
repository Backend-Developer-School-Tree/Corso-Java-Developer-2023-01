package turista_facoltoso.database;

import turista_facoltoso.entities.*;
import turista_facoltoso.entities.users.Utente;

import java.util.HashMap;
import java.util.HashSet;

public class Database {

    private static HashMap<Integer, Utente> utenti = new HashMap<>();
    private static HashMap<Integer, Abitazione> abitazioni = new HashMap<>();
    private static HashMap<Integer, Prenotazione> prenotazioni = new HashMap<>();
    private static HashMap<Integer, Feedback> feedbacks = new HashMap<>();

    private static HashMap<Integer, HashSet<Integer>> abitazioniHost = new HashMap<>();

    public static void addAbitazione(Abitazione ab) {
        abitazioni.put(ab.getId(), ab);
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

}
