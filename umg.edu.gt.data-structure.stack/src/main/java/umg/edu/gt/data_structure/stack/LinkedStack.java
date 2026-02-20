package umg.edu.gt.data_structure.stack;

public class LinkedStack<T> {

    private Node<T> top;
    private Node<T> bottom;
    private int count;

    public LinkedStack() {
        this.top = null;
        this.bottom = null;
        this.count = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value);

        if (isEmpty()) {
            top = newNode;
            bottom = newNode;
        } else {
            newNode.setNext(top);
            top = newNode;
        }

        count++;
    }

    public T pop() {
        if (isEmpty()) return null;

        T value = top.getValue();
        top = top.getNext();
        count--;

        if (isEmpty()) {
            bottom = null;
        }

        return value;
    }

    public T peek() {
        if (isEmpty()) return null;
        return top.getValue();
    }

    public int getCount() {
        return count;
    }

    public Node<T> getNodeInit() {
        return bottom;
    }
}