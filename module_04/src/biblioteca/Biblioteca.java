package biblioteca;

import java.util.Arrays;
import java.util.Comparator;

public class Biblioteca {

    private Libro[] books;

    public Biblioteca(Libro[] books) {
        this.books = books;
        this.sortBooks();
        // this.sortBooks2();
    }

    public boolean esisteLibro(Libro bookToFind) { return esisteLibro(bookToFind.getIndex()); }

    public boolean esisteLibro(int bookToFind) {
        for (Libro book : books)
            if (book.getIndex() == bookToFind)
                return true;
        return false;
    }

    public Libro[] getLibriOrdinati() { return books; }

    public int[] getIndiciLibriOrdinati() {
        Libro[] orderedBooks = getLibriOrdinati();
        int[] bookIndexes = new int[orderedBooks.length];
        for (int i = 0; i < orderedBooks.length; i++) bookIndexes[i] = orderedBooks[i].getIndex();
        return bookIndexes;
    }

    /**
     * Ordina gli indici dei libri tramite l'algoritmo Selection Sort (https://en.wikipedia.org/wiki/Selection_sort).
     * Questo algoritmo è poco efficiente, in quanto per un array di lunghezza n effettua sempre n*n confronti.
     */
    private void sortBooks() {
        for (int i = 0; i < books.length - 1; i++)
        {
            int minIndex = i;

            for (int j = i + 1; j < books.length; j++)
                if (books[j].getIndex() < books[minIndex].getIndex())
                    minIndex = j;

            Libro minIndexBook = books[minIndex];
            books[minIndex] = books[i];
            books[i] = minIndexBook;
        }
    }

    /**
     * Ordina gli indici dei libri tramite il metodo di sorting di default implementato in Java (ottimizzando i confronti: n*log_n).
     * Il criterio di ordinamento è definito tramite il metodo statico `comparing` della classe `Comparator`,
     * per ordinare in base al valore di getIndex della classe Libro (Libro::getIndex).
     * Vedremo la classe Comparator e come utilizzarla nel dettaglio dal modulo 6 in poi.
     */
    private void sortBooks2() { Arrays.sort(books, Comparator.comparing(Libro::getIndex)); }

    public static void main(String[] args) {
        System.out.println(new Libro[0].length);
        Libro[] books = new Libro[]{
                new Libro(123, "Luciana Litizzetto", "I dolori del giovane Programmatore"),
                new Libro(4, "Super Mario", "Errori da non ripetere"),
                new Libro(98, "Luigi Pirandino", "Uno, nessuno e diecimila bug"),
                new Libro(33, "Roberto Roberti", "Come programmare in Java da zero"),
                new Libro(76, "Piero Java", "Mille splendidi errori"),
                new Libro(2, "Lavinia Pitoni", "Non si esce vivi dalle biblioteche"),
                new Libro(235, "Luciana Litizzetto Jr.", "I dolori del vecchio Programmatore")
        };

        Biblioteca library = new Biblioteca(books);
        System.out.println(library.esisteLibro(76));

        int[] booksIndexes = library.getIndiciLibriOrdinati();
        System.out.println(booksIndexes[0] == 2);
        System.out.println(booksIndexes[1] == 4);
        System.out.println(booksIndexes[2] == 33);
        System.out.println(booksIndexes[3] == 76);
        System.out.println(booksIndexes[4] == 98);
        System.out.println(booksIndexes[5] == 123);
        System.out.println(booksIndexes[6] == 235);
    }
}
