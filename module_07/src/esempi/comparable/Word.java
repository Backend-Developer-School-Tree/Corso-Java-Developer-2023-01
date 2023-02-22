import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Word implements Comparable<Word> {
    private int i;
    private String word;

    Word(int i, String word) {
        this.i = i;
        this.word = word;
    }

    public int getI() { return i; }
    public String getWord() { return word; }

    @Override
    public int compareTo(Word o) {
        // return 0  --> this == word
        // return -1 --> this < word
        // return +1 --> this > word
        int compareStr = this.word.compareTo(o.getWord());

        // quando le stringhe sono uguali compariamo gli interi
        if (compareStr == 0) return Integer.compare(this.i, o.getI());

        return compareStr;

        /*
        // return Integer.compare(this.i, o.getI());

        if (this.i == word.getI()) return 0;
        else if (this.i < word.getI()) return -1;
        else return +1;
         */
    }

    @Override
    public String toString() {
        return "Word{" +
                "i=" + i +
                ", word='" + word + '\'' +
                '}';
    }



    public static void main(String[] args) {

        List<Word> words = Arrays.asList(new Word(1, "ciao"), new Word(2, "zeta"), new Word(3, "beta"));

        Comparator<Word> compareByWord = Comparator.comparing(Word::getWord);
        // equivalente alla lambda:      Comparator.comparing(w -> w.getWord());

        Comparator<Word> compareBySecondChar = Comparator.comparing(w -> w.getWord().charAt(1));

        words.sort(compareByWord);
        System.out.println(words);
        words.sort(compareBySecondChar);
        System.out.println(words);

        words.sort(new WordComparator());
        System.out.println(words);
    }
}
