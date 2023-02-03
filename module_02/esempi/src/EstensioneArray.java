import java.util.Arrays;

public class EstensioneArray {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3};
        System.out.println(Arrays.toString(array));
        // assegnando un valore ad un indice valido sovrascriviamo gli elementi già presenti nell'array
        array[0] = 5;
        System.out.println(Arrays.toString(array));
        // questa operazione invece genererebbe un errore, l'indice 3 non esiste!!
        // array[3] = 5;

        // possiamo estendere un array creandone uno nuovo di lunghezza maggiore
        // in questo caso di lunghezza uguale al precedente array + 1, così da poter aggiungere un elemento
        int[] nuovoArray = new int[array.length + 1];
        // copiamo tutti gli elementi del "vecchio" array nel "nuovo"
        for (int i = 0; i < array.length; i++) {
            nuovoArray[i] = array[i];
        }
        // l'array precedente rimane invariato
        System.out.println(Arrays.toString(array));
        // il nuovo array è una "copia" del precedente ma con un nuovo valore aggiunto in coda (inizializzato a 0)
        System.out.println(Arrays.toString(nuovoArray));
        // assegnamo il riferimento in memoria del nuovo array a quello precedente
        // ATTENZIONE: in questo modo ogni modifica ad "array" si riflette su "nuovoArray" e viceversa
        array = nuovoArray;
        array[3] = 5;

        // creiamo un array di dimensione 1 ed estendiamolo step by step con la funzione ad hoc da noi definita
        int[] array2 = new int[1];
        array2[0] = 1;
        array2 = appendToArray(array2, 2);
        array2 = appendToArray(array2, 3);
        array2 = appendToArray(array2, 4);
        System.out.println(array2[0]);
        System.out.println(array2[1]);
        System.out.println(array2.length);
    }

    // funzione per estendere un array di 1 e aggiungervi un elemento
    public static int[] appendToArray(int[] array, int newElement) {
        int[] nuovoArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            nuovoArray[i] = array[i];
        }
        nuovoArray[array.length] = newElement;
        return nuovoArray;
    }
}
