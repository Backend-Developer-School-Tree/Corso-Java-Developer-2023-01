# Biblioteca 🛴

Scrivere un programma che permetta di gestire una Biblioteca semplificata, in grado di gestire un array
di indici (interi) dei libri che contiene. La Biblioteca viene costruita a partire da un array di 
indici di libri.
In particolare, implementare i seguenti metodi:
- `esisteLibro`: prende un indice e restituisce true se esiste il libro con questo indice, false altrimenti
- `getIndiciLibriOrdinati`: ritorna la lista degli indici di libri presenti nella biblioteca, in ordine ascendente

Potete utilizzare il seguente codice come test:

```java
public class Main {
    public static void main(String[] args) {
        int[] values = new int[7];
        values[0] = 123;
        values[1] = 4;
        values[2] = 98;
        values[3] = 33;
        values[4] = 76;
        values[5] = 2;
        values[6] = 235;
        Biblioteca biblioteca = new Biblioteca(values);
        System.out.println(biblioteca.esisteLibro(76));
        int[] libriOrdinati = biblioteca.getIndiciLibriOrdinati();
        System.out.println(libriOrdinati[0] == 2);
        System.out.println(libriOrdinati[1] == 4);
        System.out.println(libriOrdinati[2] == 33);
        System.out.println(libriOrdinati[3] == 76);
        System.out.println(libriOrdinati[4] == 98);
        System.out.println(libriOrdinati[5] == 123);
        System.out.println(libriOrdinati[6] == 235);
    }
}
```

Suggerimento: riutilizzate il codice dei precedenti esercizi

## Bonus stage

Rendere la biblioteca funzionante con dei libri veri e propri invece che con solo i loro indici.
Creare quindi una classe Libro con delle proprie caratteristiche, tra cui l'indice che usavamo prima,
ad esempio nome, autore, categoria, ecc, e modificare di conseguenza la classe Biblioteca ed il main di test.

NOTA: l'ordinamento dei libri può essere implementato da zero (ad esempio implementando il [selection sort](https://en.wikipedia.org/wiki/Selection_sort) o l'[insertion sort](https://en.wikipedia.org/wiki/Insertion_sort)) o fatto in maniera più smart con un Comparator, che però vedremo dal modulo 6 in poi (una volta sostenuti questi moduli, è possibile riprendere in mano l'esercizio per migliorare il risultato sfruttando le nuove conoscenze).

```Java
// dato un array di oggetti di tipo Libro (Libro[] books), i quali contengono un metodo getIndex
// possiamo ordinarlo in base all'index con Arrays.sort, aggiungendo il seguente Comparator come secondo parametro
Arrays.sort(books, Comparator.comparing(Libro::getIndex));
```





