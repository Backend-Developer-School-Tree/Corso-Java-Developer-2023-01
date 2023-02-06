package esempi;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        // inizializziamo un array di lunghezza 3 con valori preimpostati
        int[] array = new int[]{1,2,3};

        // inizializziamo un array "vuoto" di lunghezza 3
        int[] array2 = new int[3];
        // assegnamo gli elementi 1, 2, 3
        array2[0] = 1;
        array2[1] = 2;
        array2[2] = 3;

        // analogamente, iteriamo e stampiamo gli elementi dell'array dall'indice 0 fino all'ultimo
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }

        // se non necessitiamo degli indici, è possibile iterare direttamente elemento per elemento tramite for-each
        for (int elemento : array2) {
            System.out.println(elemento);
        }

        // la stampa di un array può essere effettuata in maniera più "smart" tramite Arrays.toString
        System.out.println(Arrays.toString(array2));

        // sommiamo, tramite la funzione "somma" da noi definita, tutti gli elementi dell'array: 1+2+3=6
        System.out.println(somma(array2));

        // inizializziamo una matrice 3x3 (3 righe e 3 colonne)
        // int[][] matrice = new int[3][3];
        int[][] matrice = new int[][]{{1,2,3}, {1,2,3}, {1,2,3}};

        // stampiamo il contenuto della prima riga
        System.out.println(Arrays.toString(matrice[0]));

        // stampiamo il contenuto riga per riga
        for (int i = 0; i < matrice.length; i++) {
            System.out.println(Arrays.toString(matrice[i]));
        }

        // stampiamo il contenuto della prima colonna (il primo valore di ogni riga)
        for (int i = 0; i < matrice.length; i++) {
            System.out.println(matrice[i][0]);
        }
    }

    // funzione che somma tutti gli elementi di un array e ritorna il risultato
    public static int somma(int[] array) {
        int tot = 0;
        for (int i = 0; i < array.length; i++) {
            tot += array[i];
        }
        return tot;
    }
}
