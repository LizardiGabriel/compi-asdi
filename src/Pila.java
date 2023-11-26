import java.util.EmptyStackException;
import java.util.LinkedList;

public class Pila<T> {
    private LinkedList<T> list = new LinkedList<T>();

    public void push(T item) {
        list.addFirst(item);
    }

    public T pop() {
        if (list.isEmpty()) {
            throw new EmptyStackException();
        }
        return list.removeFirst();
    }

    public T peek() {
        if (list.isEmpty()) {
            throw new EmptyStackException();
        }
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}