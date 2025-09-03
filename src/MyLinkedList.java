import java.util.Iterator;

public class MyLinkedList<E> implements IList{
    private Node<E> first;
    private Node<E> last;
    private int size;

    @Override
    public Iterator<E> iterator(){
        return new Iterator<E>() {
            Node<E> node = first;
            @Override
            public boolean hasNext() {
                return node!= null;
            };

            @Override
            public E next() {
                E data = node.data;
                node = node.next;
                return data;
            };
        };
    }

    @Override
    public boolean add(int index, Object element) {
        //TODO
        return false;
    }

    @Override
    public int indexOf(Object o) {
        //TODO
        return 0;
    }

    @Override
    public void clear() {
        first = last = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int index) {
        //TODO
        return null;
    }

    @Override
    public int lastIndexOf(Object o) {
        //TODO
        return 0;
    }

    @Override
    public Object remove(int index) {
        //TODO
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        //TODO
        return null;
    }



    private static class Node<E>{
        Node <E> prev;
        Node <E> next;
        E data;


        public Node(Node<E> prev, Node<E> next, E data) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }
    }
}
