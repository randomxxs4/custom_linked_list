package company;

import java.util.Collection;
import java.util.Iterator;

public interface CustomLinkedList<T> {
    boolean add(int index, T element);

    boolean add(T element);

    boolean addAll(int index, Collection<T> collection);

    boolean addAll(Collection<T> collection);

    boolean remove(T elem);

    boolean remove(int index);

    int getSize();

    void setLastNode(T element);

    void setFirstNode(T element);

    void removeAll();

    boolean removeFirst();

    boolean removeLast();

    T getFirstElementValue();

    T getLastElementValue();

    int getIndex(T element);

    T getElement(int index);

    T getElement(T element);

    Iterator iterator(int index);
}
