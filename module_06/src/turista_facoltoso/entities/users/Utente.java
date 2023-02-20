package turista_facoltoso.entities.users;

import turista_facoltoso.admin.AirBnB;
import turista_facoltoso.database.Database;
import turista_facoltoso.entities.Abitazione;
import turista_facoltoso.entities.Prenotazione;
import turista_facoltoso.enumerators.Voto;

import java.time.LocalDate;
import java.util.HashSet;

public class Utente {

    // attributi statici
    private static int idTotale = 0;

    // attributi
    protected int id;
    protected String nome;
    protected String cognome;
    protected String email;
    protected String indirizzo;

    public Utente(String nome, String cognome, String email, String indirizzo) {
        this.id = idTotale++;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.indirizzo = indirizzo;
    }

    // getter
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public String getEmail() { return email; }
    public String getIndirizzo() { return indirizzo; }

    // setter
    public void setNome(String nome) { this.nome = nome; }
    public void setCognome(String cognome) { this.cognome = cognome; }
    public void setEmail(String email) { this.email = email; }
    public void setIndirizzo(String indirizzo) { this.indirizzo = indirizzo; }

    // metodi
    public void addPrenotazione(int idAbitazione, LocalDate inizioPren, LocalDate finePren) {
        if (AirBnB.isDisponibile(idAbitazione, inizioPren, finePren)) {
            Prenotazione p = new Prenotazione(inizioPren, finePren, this.id, idAbitazione);
            Database.addPrenotazione(p);
        }
        else {
            System.out.println("Abitazione non disponibile in quel periodo di tempo!");
        }

        // da completare
    }

    public void removePrenotazione(int idPrenotazione) {
        Prenotazione pr = Database.getPrenotazioni().get(idPrenotazione);
        if (pr.getIdUtente() == this.id) { Database.removePrenotazione(pr); } // rimuovo solo se la prenotazione è fatta dall'utente
        else { System.out.println("Non puoi rimuovere una prenotazione non tua!"); }
    }

    public void addFeedback(String titolo, String commento, Voto voto, int idPren) {

    }

    public void removeFeedback(int idFeedback) {}

    public void removeFeedbackByPrenotazione(int idPrenotazione) {}

    public HashSet<Prenotazione> prenotazioniEffettuate() {
        return null;
    }
    public void visualizzaAbitazioniDisponibili(LocalDate inizio, LocalDate fine) {
        for (Abitazione ab : AirBnB.abitazioniDisponibili(inizio, fine)) {
            System.out.println(ab);
        }
    }



}
