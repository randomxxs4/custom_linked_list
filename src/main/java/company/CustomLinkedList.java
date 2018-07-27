package company;

public interface CustomLinkedList<T> {
    boolean add(int index, T element);

    boolean add(T element);

    boolean remove(T elem);

    boolean remove(int index);

    void removeAll();

    boolean removeFirst();

    boolean removeLast();

    T getFirstElementValue();

    T getLastElementValue();

    int getIndex(T element);

    T getElement(int index);

    T getElement(T element);
}
