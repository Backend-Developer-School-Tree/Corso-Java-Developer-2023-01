package turista_facoltoso.entities;

public class Utente {

    // attributi statici
    private static int idTotale = 0;

    // attributi
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private String indirizzo;

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
}
