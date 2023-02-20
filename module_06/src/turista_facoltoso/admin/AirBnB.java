package turista_facoltoso.admin;

import turista_facoltoso.database.Database;
import turista_facoltoso.entities.Abitazione;

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

    public static boolean isDisponibile(int codiceAb, LocalDate inizio, LocalDate fine) { return true; }

}
