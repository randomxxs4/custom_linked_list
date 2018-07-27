package company;

import java.util.Collection;
import java.util.Iterator;

public class CustomLinkedListImpl<T> implements CustomLinkedList<T> {

    private int size = 0;
    private Node<T> first;
    private Node<T> last;

    public CustomLinkedListImpl() {
    }

    public boolean add(int index, T element) {
        if (index < size && index >= 0) {
            if (index == size) {
                setLastNode(element);
                return true;
            } else {
                Node<T> nodeByIndex = getNodeByIndex(index);
                if (nodeByIndex != null) {
                    setElementIntoList(element, nodeByIndex);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean add(T element) {
        setLastNode(element);
        return true;
    }

    public boolean addAll(int index, Collection<T> collection) {
        if (index <= size && index >= 0) {
            Object[] objects = collection.toArray();
            if (objects.length == 0) {
                return false;
            }
            Node<T> prevNode;
            Node<T> currentNode;

            if (index != size) {
                currentNode = getNodeByIndex(index);
                prevNode = currentNode.getPrevElement();
            } else {
                currentNode = null;
                prevNode = last;
            }

            for (int i = 0; i < objects.length; i++) {
                Node<T> node = new Node<>(prevNode, null, (T) objects[i]);
                if (prevNode != null) {
                    prevNode.setNextElement(node);
                } else {
                    first = node;
                }
                prevNode = node;
            }

            if (currentNode != null) {
                prevNode.setNextElement(currentNode);
                currentNode.setPrevElement(prevNode);
            } else {
                last = prevNode;
            }
            size += objects.length;
            return true;
        }
        return false;
    }

    public boolean addAll(Collection<T> collection) {
        return addAll(size, collection);
    }

    public boolean remove(int index) {
        Node<T> nodeByIndex = getNodeByIndex(index);
        if (nodeByIndex != null) {
            deleteElement(nodeByIndex);
            return true;
        }
        return false;
    }

    public boolean remove(T elem) {
        int index = getIndex(elem);
        Node<T> nodeByIndex = getNodeByIndex(index);
        if (nodeByIndex != null) {
            deleteElement(nodeByIndex);
            return true;
        }
        return false;
    }

    public void removeAll() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }


    public boolean removeFirst() {
        if (first != null) {
            deleteFirstElement(first);
            return true;
        }
        return false;
    }

    public boolean removeLast() {
        if (last != null) {
            deleteLastElement(last);
            return true;
        }
        return false;
    }


    public T getElement(int index) {
        Node<T> nodeByIndex = getNodeByIndex(index);
        if (nodeByIndex != null) {
            return nodeByIndex.getValue();
        }
        throw new RuntimeException("get");
    }

    @Override
    public T getElement(T element) {
        int index = getIndex(element);
        Node<T> nodeByIndex = getNodeByIndex(index);
        if (nodeByIndex != null) {
            return nodeByIndex.getValue();
        }
        return null;
    }

    @Override
    public Iterator iterator(int index) {
        return new LinkedListIterator(index);
    }

    public void setLastNode(T element) {
        Node<T> lastNode = last;
        Node<T> currentNode = new Node<>(lastNode, null, element);
        last = currentNode;
        if (lastNode == null) {
            first = currentNode;
        } else {
            lastNode.setNextElement(currentNode);
        }
        size++;
    }

    public void setFirstNode(T element) {
        Node<T> firtNode = first;
        Node<T> currentNode = new Node<>(null, firtNode, element);
        first = currentNode;
        if (firtNode == null) {
            last = currentNode;
        } else {
            firtNode.setPrevElement(currentNode);
        }
        size++;
    }

    public void setElementIntoList(T element, Node<T> node) {
        Node<T> prev = node.getPrevElement();
        Node<T> currentNode = new Node<>(prev, node, element);
        node.setPrevElement(currentNode);
        if (prev == null) {
            first = currentNode;
        } else {
            prev.setNextElement(currentNode);
        }
        size++;
    }

    private void deleteFirstElement(Node<T> firstNode) {
        if (first == firstNode) {
            Node<T> nextElement = firstNode.getNextElement();
            first = nextElement;
            if (nextElement == null) {
                last = null;
            } else {
                first.setPrevElement(null);
            }
            size--;
        }
    }

    private void deleteLastElement(Node<T> lastNode) {
        Node<T> prevElement = lastNode.getPrevElement();
        last = prevElement;
        if (prevElement == null) {
            first = null;
        } else {
            last.setNextElement(null);
        }
        size--;

    }

    private void deleteElement(Node<T> node) {
        Node<T> nextElement = node.getNextElement();
        Node<T> prevElement = node.getPrevElement();
        if (prevElement == null) {
            first = nextElement;
        } else {
            prevElement.setNextElement(nextElement);
            node.setPrevElement(null);
        }

        if (nextElement == null) {
            last = prevElement;
        } else {
            nextElement.setPrevElement(prevElement);
            node.setNextElement(null);
        }
        size--;
    }

    public T getFirstElementValue() {
        if (first == null) {
            throw new RuntimeException("getFirstElementValue");
        }
        return first.getValue();
    }

    public T getLastElementValue() {
        if (last == null) {
            throw new RuntimeException("getLastElementValue");
        }
        return last.getValue();
    }

    public int getIndex(T element) {

        int index = 0;

        if (element != null) {
            for (Node<T> firstNode = this.first; firstNode != null; firstNode = firstNode.getNextElement()) {
                if (element.equals(firstNode.getValue())) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<T> firstNode = this.first; firstNode != null; firstNode = firstNode.getNextElement()) {
                if (firstNode.getValue() == null) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    private Node<T> getNodeByIndex(int index) {
        if (index >= 0 && index < size) {
            int halfSize = size / 2;

            if (index < halfSize) {
                Node<T> node = this.first;
                for (int i = 0; i < index; i++) {
                    node = node.getNextElement();
                }
                return node;
            } else {
                Node<T> node = this.last;
                for (int i = size - 1; i > index; i--) {
                    node = node.getPrevElement();
                }
                return node;
            }
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    class LinkedListIterator implements Iterator<T> {

        private Node<T> currentNode;
        private Node<T> next;
        private int nextElementIndex;

        public LinkedListIterator(int index) {
            if (index < size && index >= 0) {
                Node<T> nodeByIndex = getNodeByIndex(index);
                next = nodeByIndex;
            }
            nextElementIndex = index;
        }

        @Override
        public boolean hasNext() {
            return nextElementIndex < size;
        }

        @Override
        public T next() {
            if (hasNext()) {
                currentNode = next;
                next = next.getNextElement();
                nextElementIndex++;
                return currentNode.getValue();
            }
            throw new RuntimeException("in iterator. method - next");
        }
    }
}