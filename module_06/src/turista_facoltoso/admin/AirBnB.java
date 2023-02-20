package turista_facoltoso.admin;

import turista_facoltoso.database.Database;
import turista_facoltoso.entities.Abitazione;
import turista_facoltoso.entities.Prenotazione;
import turista_facoltoso.entities.users.Host;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeMap;

public class AirBnB {

    public static HashSet<Abitazione> abitazioniDisponibili(LocalDate inizio, LocalDate fine) {
        HashSet<Abitazione> abDisponibili = new HashSet<>(); // creo un hashset
        for (Integer codiceAb : Database.getAbitazioni().keySet()) { // per ogni abitazione nel db
            if (isDisponibile(codiceAb, inizio, fine)) { // se tra quelle date è disponibile
                abDisponibili.add(Database.getAbitazioni().get(codiceAb)); // aggiungila al set di abitazioni disponibili
            }
        }
        return abDisponibili;
    }

    /*
       Una abitazione è disponibile se:
           1) Le date di inizio e fine prenotazione sono contenute nell'interavallo definito dalle date di disponibilità dell'abitazione AND
           2) Non esiste un'altra prenotazione che interseca le date di inizio e di fine della ricerca di disponibilità
        */
    public static boolean isDisponibile(int codiceAb, LocalDate inizio, LocalDate fine) {
        Abitazione ab = Database.getAbitazioni().get(codiceAb);
        // 1) Le date di inizio e fine prenotazione sono contenute nell'interavallo definito dalle date di disponibilità dell'abitazione
        LocalDate inizioDisp = ab.getInizioDisp();
        LocalDate fineDisp = ab.getFineDisp();
        boolean first = (inizio.isAfter(inizioDisp) || inizio.isEqual(inizioDisp)) && (fine.isBefore(fineDisp) || fine.isEqual(fineDisp)); // true se inizio è successivo a inizioDisp e se fineDisp precede fine
        boolean second = true;
        HashSet<Integer> codiciPrenotazioni = Database.getPrenotazioniAbitazioni().get(codiceAb);
        for (Integer codicePren : codiciPrenotazioni) {
            Prenotazione pr = Database.getPrenotazioni().get(codicePren);
            if ( !(inizio.isAfter(pr.getFinePren()) || fine.isBefore(pr.getInizioPren()))) second = false;
        }
        return first && second;
    }

    // questo metodo prende in input una prenotazione e ritorna true se è stata effettuata nell'ultimo mese
    public static boolean prenLastMonth(Prenotazione p) {
        LocalDateTime istantePren = p.getIstantePren();
        LocalDateTime oneMonthAgo = LocalDateTime.now().minusMonths(1);
        if (istantePren.isAfter(oneMonthAgo)) {
            return true;
        }
        return false;
    }

    // funzionalità
    // 1) ottenere le abitazioni corrispondente ad un certo codice host
    public static HashSet<Abitazione> abitazioniHost(int codiceHost) {
        HashSet<Abitazione> abitazioni = new HashSet<>();
        HashSet<Integer> abHost = Database.getAbitazioniHost().get(codiceHost);
        for (Integer codiceAb : abHost) {
            Abitazione ab = Database.getAbitazioni().get(codiceAb);
            abitazioni.add(ab);
        }
        return abitazioni;
    }

    // 2) ottenere l'ultima prenotazione dato un id utente
    public static Prenotazione lastPrenotazione(int idUtente) {
        HashSet<Integer> prenotazioniUtente = Database.getPrenotazioniEffettuate().get(idUtente);
        Prenotazione pMax = null;
        LocalDateTime dataMax = null;
        for (Integer codicePren : prenotazioniUtente) {
            Prenotazione p = Database.getPrenotazioni().get(codicePren);
            if (pMax == null) {
                pMax = p;
                dataMax = p.getIstantePren();
            }
            else {
                if (p.getIstantePren().isAfter(dataMax)) {
                    pMax = p;
                    dataMax = p.getIstantePren();
                }
            }
        }
        return pMax;
    }

    // 3) ottenere l'abitazione più gettonata nell'ultimo mese
    public static Abitazione abitazioneGettonata() {
        Abitazione ab = null;
        int maxPren = 0;
        for (Integer codiceAb : Database.getPrenotazioniAbitazioni().keySet()) {
            HashSet<Integer> prenotazioniAb = Database.getPrenotazioniAbitazioni().get(codiceAb);
            HashSet<Integer> lastMonth = new HashSet<>();
            for (Integer codicePren : prenotazioniAb) {
                Prenotazione p = Database.getPrenotazioni().get(codicePren);
                if (prenLastMonth(p))  lastMonth.add(codicePren);
            }
            if (lastMonth.size() > maxPren) {
                ab = Database.getAbitazioni().get(codiceAb);
                maxPren = lastMonth.size();
            }
        }
        return ab;
    }

    // 4) ottenere gli host con più prenotazioni nell'ultimo mese (ne torniamo 5)
    public static HashSet<Host> hostPiuPrenotazioni() {
        TreeMap<Integer, HashSet<Host>> mappaHost = new TreeMap<>(Collections.reverseOrder());
        HashSet<Host> result = new HashSet<>();
        for (Integer idHost : Database.getPrenotazioniRicevute().keySet()) {
            Host h = (Host) Database.getUtenti().get(idHost);
            HashSet<Integer> lastMonth = new HashSet<>();
            HashSet<Integer> prenotazioniHost = Database.getPrenotazioniRicevute().get(idHost);
            for (Integer codicePren : prenotazioniHost) {
                Prenotazione p = Database.getPrenotazioni().get(codicePren);
                if (prenLastMonth(p))  lastMonth.add(codicePren);
            }
            if (mappaHost.containsKey(lastMonth.size())) {
                HashSet<Host> vecchioValore = mappaHost.get(lastMonth.size());
                vecchioValore.add(h);
                mappaHost.put(lastMonth.size(), vecchioValore);
            }
            else {
                HashSet<Host> vecchioValore = new HashSet<>();
                vecchioValore.add(h);
                mappaHost.put(lastMonth.size(), vecchioValore);
            }
        } // alla fine di questo for abbiamo la treemap completa
        for (Integer punteggio : mappaHost.keySet()) {
            HashSet<Host> hostPunteggio = mappaHost.get(punteggio);
            for (Host h : hostPunteggio) {
                result.add(h);
                if (result.size() == 5) {
                    return result;
                }
            }
        }
        return result;
    }

    // 5) ottenere tutti i super-host
    public static HashSet<Host> superHost() {
        HashSet<Host> superHosts = new HashSet<>();
        for (Integer codiceHost : Database.getPrenotazioniRicevute().keySet()) {
            Host h = (Host) Database.getUtenti().get(codiceHost);
            if ( Database.getPrenotazioniRicevute().get(codiceHost).size() >= 100 ) {
                superHosts.add(h);
            }
        }
        return superHosts;
    }

}
