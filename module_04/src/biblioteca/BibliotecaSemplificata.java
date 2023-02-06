package biblioteca;

import java.util.Arrays;

public class BibliotecaSemplificata {

    private int[] booksIndexes;

    public BibliotecaSemplificata(int[] booksIndexes) {
        Arrays.sort(booksIndexes);
        this.booksIndexes = booksIndexes;
    }

    public boolean esisteLibro(int bookToFind) {
        for (int bookIndex : booksIndexes)
            if (bookIndex == bookToFind)
                return true;
        return false;
    }

    public int[] getIndiciLibriOrdinati() {
        return booksIndexes;
    }

    public static void main(String[] args) {
        int[] values = new int[7];
        values[0] = 123;
        values[1] = 4;
        values[2] = 98;
        values[3] = 33;
        values[4] = 76;
        values[5] = 2;
        values[6] = 235;
        BibliotecaSemplificata library = new BibliotecaSemplificata(values);
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