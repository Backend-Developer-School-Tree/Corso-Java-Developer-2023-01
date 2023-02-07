package riparazioni;

import java.util.Arrays;

/**
 * Classe per gestire una lista dinamica di Riparazioni,
 * basata su un array che ad ogni nuovo inserimento viene esteso di 1 (come visto precedentemente nel modulo 2)
 */
public class ListaDiRiparazioni {

    private Riparazione[] riparazioni = new Riparazione[0];

    public ListaDiRiparazioni(Riparazione[] riparazioni) {
        for (Riparazione riparazione : riparazioni)
            add(riparazione);
    }

    /**
     * @return lunghezza della lista di tecnici
     */
    public int length() { return riparazioni.length; }

    /**
     * Aggiunge una riparazione nella lista di riparazioni, estendendo la dimensione dell'array di 1
     *
     * @param riparazione il Tecnico da aggiungere alla lista
     */
    public void add(Riparazione riparazione) {
        if (riparazione != null) {
            // estendiamo l'array di riparazioni creandone uno nuovo temporaneo di lunghezza maggiore di 1
            // così da poter aggiungere una nuova riparazione
            Riparazione[] nuovoArray = new Riparazione[riparazioni.length + 1];
            // copiamo ogni riparazione nel nuovo array esteso di lunghezza
            for (int i = 0; i < riparazioni.length; i++)
                nuovoArray[i] = riparazioni[i];
            // aggiungiamo la nuova riparazione in ultima posizione
            nuovoArray[riparazioni.length] = riparazione;
            // salviamo nel campo riparazioni il riferimento in memoria dell'array esteso con la nuova riparazione
            riparazioni = nuovoArray;
        }
    }

    /**
     * Ritorna la riparazione all'indice in input
     *
     * @param i indice della riparazione nella lista
     * @return la Riparazione all'indice in input
     */
    public Riparazione get(int i) {
        if (i > riparazioni.length) return null;
        return riparazioni[i];
    }

    @Override
    public String toString() { return Arrays.toString(riparazioni); }

    public static void main(String[] args) {
        ListaDiRiparazioni lista = new ListaDiRiparazioni(new Riparazione[]{new Riparazione("Indirizzo test", 1)});
        lista.add(new Riparazione("Indirizzo test 2", 2));
        for (int i = 0; i < lista.length(); i++)
            System.out.println(lista.get(i));
    }
}
