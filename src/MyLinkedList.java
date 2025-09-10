import java.util.Iterator;

public class MyLinkedList<E> implements IList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> node = first;


            @Override
            public boolean hasNext() {
                return node != null;
            }


            @Override
            public E next() {
                E data = node.data;
                node = node.next;
                return data;
            }
        };
    }


    // O(1)
    @Override
    public void clear() {
        first = last = null;
        size = 0;


    }


    // O(1)
    @Override
    public int size() {
        return size;
    }


    // O(1)
    @Override
    public boolean add(E element) {
        Node<E> newNode = new Node<>(last, element, null);
        if (last != null) {
            last.next = newNode;
        } else {
            first = newNode;
        }
        last = newNode;
        size++;
        return true;
    }


    // O(n), insert to first and last O(1)
    @Override
    public boolean add(int index, E element) {
        if (index == size) {
            return add(element);
        }
        if (index == 0) {
            Node<E> newNode = new Node<>(null, element, first);
            first.prev = newNode;
            first = newNode;
        } else {
            Node<E> node = getNodeByIndex(index);
            Node<E> newNode = new Node<>(node.prev, element, node);
            node.prev = newNode;
            newNode.prev.next = newNode;
        }
        size++;
        return true;
    }


    // O(n)
    private Node<E> getNodeByIndex(int index) {
        checkIndex(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }


    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index + " out of bounds");
        }


    }


    // O(n)
    @Override
    public E get(int index) {
        Node<E> node = getNodeByIndex(index);
        return node.data;
    }


    // O(n)
    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o != null) {
            for (Node<E> node = first; node != null; node = node.next, index++) {
                if (o.equals(node.data)) {
                    return index;
                }
            }
        } else {
            for (Node<E> node = first; node != null; node = node.next, index++) {
                if (o == node.data) {
                    return index;
                }
            }
        }
        return -1;
    }


    // O(n)
    @Override
    public int lastIndexOf(Object o) {
        int index = size - 1;
        if (o != null) {
            for (Node<E> x = last; x != null; x = x.prev, index--) {
                if (o.equals(x.data)) {
                    return index;
                }
            }
        } else {
            for (Node<E> x = last; x != null; x = x.prev, index--) {
                if (o == x.data) {
                    return index;
                }
            }
        }
        return -1;
    }


    // O(n)
    @Override
    public E remove(int index) {
        Node<E> node = getNodeByIndex(index);
        return unlink(node);
    }


    private E unlink(Node<E> node) {
        E victim = node.data;
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        if (prev != null) {
            prev.next = next;
            node.prev = null;
        } else {
            first = next;
        }
        if (next != null) {
            next.prev = prev;
            node.next = null;
        } else {
            last = prev;
        }
        node.data = null;
        size--;
        return victim;
    }


    // O(n)
    @Override
    public E set(int index, E element) {
        Node<E> node = getNodeByIndex(index);
        E victim = node.data;
        node.data = element;
        return victim;
    }

    private static class Node<E> {
        Node<E> prev;
        E data;
        Node<E> next;


        public Node(Node<E> prev, E data, Node<E> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }



}
