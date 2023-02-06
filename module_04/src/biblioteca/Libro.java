package biblioteca;

public class Libro {

    private int index;
    private String author;
    private String name;

    public Libro(int index, String author, String name) {
        this.index = index;
        this.author = author;
        this.name = name;
    }

    public int getIndex() { return index; }
}
