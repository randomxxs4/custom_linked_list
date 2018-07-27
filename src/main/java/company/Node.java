package company;

public class Node<T> {
    private Node<T> prevElement;
    private Node<T> nextElement;
    private T value;

    public Node() {
    }

    public Node(Node<T> prevElement, Node<T> nextElement, T value) {
        this.prevElement = prevElement;
        this.nextElement = nextElement;
        this.value = value;
    }

    public Node<T> getPrevElement() {
        return prevElement;
    }

    public void setPrevElement(Node<T> prevElement) {
        this.prevElement = prevElement;
    }

    public Node<T> getNextElement() {
        return nextElement;
    }

    public void setNextElement(Node<T> nextElement) {
        this.nextElement = nextElement;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
