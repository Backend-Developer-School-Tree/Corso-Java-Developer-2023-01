package biblioteca;

import java.util.Arrays;
import java.util.Comparator;

public class Biblioteca {

    private Libro[] books;

    public Biblioteca(Libro[] books) {
        // definiamo un Comparator per ordinare in base al valore di getIndex della classe Libro
        // vedremo la classe Comparator e come utilizzarla nel dettaglio dal modulo 6 in poi
        Arrays.sort(books, Comparator.comparing(Libro::getIndex));
        this.books = books;
    }

    public boolean existsBook(Libro bookToFind) {
        for (Libro book : books)
            if (book == bookToFind)
                return true;
        return false;
    }

    public Libro[] getOrderedBooks() { return books; }

    public int[] getOrderedBooksIndexes() {
        int[] bookIndexes = new int[books.length];
        for (int i = 0; i < books.length; i++) bookIndexes[i] = books[i].getIndex();
        return bookIndexes;
    }
}
