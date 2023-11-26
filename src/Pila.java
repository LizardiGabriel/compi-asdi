import java.util.LinkedList;

public class Pila<String> {
    private LinkedList<String> list = new LinkedList<String>();

    public void push(String item) {
        list.addFirst(item);
    }

    public String pop() {
        if (list.isEmpty()) {
            System.out.println("Pila vacia");
        }
        return list.removeFirst();
    }

    public String peek() {
        if (list.isEmpty()) {
            System.out.println("Pila vacia");
        }
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}