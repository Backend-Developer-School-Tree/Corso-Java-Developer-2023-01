package esempiGenerics;

public class CoppiaDiversa<T, S> {

    private T first;
    private S second;

    public CoppiaDiversa(T first, S second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() { return first; }
    public S getSecond() { return second; }
}
