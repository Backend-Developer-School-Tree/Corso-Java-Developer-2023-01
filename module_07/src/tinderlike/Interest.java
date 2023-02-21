package tinderlike;

import java.util.Comparator;
import java.util.Objects;

public class Interest implements Comparable<Interest>{
    private String id, text;

    public Interest(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interest interest = (Interest) o;
        return Objects.equals(id, interest.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Interest o) {
        return Comparator.comparing(Interest::getId).compare(this, o);
    }
}
