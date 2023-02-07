package riparazioni;

import java.util.Arrays;

/**
 * Classe per gestire una lista dinamica di Tecnici,
 * basata su un array che ad ogni nuovo inserimento viene esteso di 1 (come visto precedentemente nel modulo 2)
 */
public class ListaDiTecnici {

    private Tecnico[] tecnici = new Tecnico[0];

    public ListaDiTecnici(Tecnico[] tecnici) {
        for (Tecnico tecnico : tecnici)
            add(tecnico);
    }

    /**
     * @return lunghezza della lista di tecnici
     */
    public int length() { return tecnici.length; }

    /**
     * Aggiunge un tecnico nella lista di tecnici, estendendo la dimensione dell'array di 1
     *
     * @param tecnico il Tecnico da aggiungere alla lista
     */
    public void add(Tecnico tecnico) {
        if (tecnico != null) {
            // estendiamo l'array di tecnici creandone uno nuovo temporaneo di lunghezza maggiore di 1
            // così da poter aggiungere un nuovo tecnico
            Tecnico[] tmp = new Tecnico[tecnici.length + 1];
            // copiamo ogni tecnico nel nuovo array esteso di lunghezza
            for (int i = 0; i < tecnici.length; i++)
                tmp[i] = tecnici[i];
            // aggiungiamo il nuovo tecnico in ultima posizione
            tmp[tecnici.length] = tecnico;
            // salviamo nel campo tecnici il riferimento in memoria dell'array esteso con il nuovo tecnico
            tecnici = tmp;
        }
    }

    /**
     * Ritorna il tecnico all'indice in input
     *
     * @param i indice del tecnico nella lista
     * @return il Tecnico all'indice in input
     */
    public Tecnico get(int i) {
        if (i > tecnici.length) return null;
        return tecnici[i];
    }

    @Override
    public String toString() { return Arrays.toString(tecnici); }

    public static void main(String[] args) {
        ListaDiTecnici lista = new ListaDiTecnici(new Tecnico[]{new Tecnico("Mario")});
        lista.add(new Tecnico("Luigi"));
        for (int i = 0; i < lista.length(); i++)
            System.out.println(lista.get(i));
    }
}
