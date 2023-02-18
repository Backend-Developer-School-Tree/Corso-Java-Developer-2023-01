package turista_facoltoso.entities;

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
}
