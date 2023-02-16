package supermercato;

import java.util.Comparator;

public class Cliente implements Comparable<Cliente> , Comparator {

    private static int idTotale = 0;
    private int id;
    private String nome;
    private String cognome;
    private int eta;

    public Cliente(String nome, String cognome, int eta) {
        this.id = idTotale++;
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    @Override
    public int compareTo(Cliente o) {
        if (this.eta > o.eta) return -1;
        else if (this.eta < o.eta) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return this.nome + " " + this.cognome;
    }


    @Override
    public int compare(Object o1, Object o2) {
        Cliente c1 = (Cliente) o1;
        Cliente c2 = (Cliente) o2;
        return c1.getEta() - c2.getEta();
    }
}
