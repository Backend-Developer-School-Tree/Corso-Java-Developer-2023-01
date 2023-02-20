package turista_facoltoso.admin;

import turista_facoltoso.database.Database;
import turista_facoltoso.entities.Abitazione;
import turista_facoltoso.entities.Prenotazione;

import java.time.LocalDate;
import java.util.HashSet;

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

}
