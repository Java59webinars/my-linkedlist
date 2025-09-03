public interface IList<E> extends Iterable<E>{
    default boolean add(E element) {
        return add(size(), element);
    }

    boolean add(int index, E element);
    default boolean contains(Object o){
        return indexOf(o) >= 0;
    }

    int indexOf(Object o);

    default boolean isEmpty(){
        return size()==0;
    }
    void clear();
    int size();
    default boolean remove(Object o) {
        int index = indexOf(o);
        if(index < 0) {
            return false;
        }
        remove(index);
        return true;
    }
    E get(int index);
    int lastIndexOf(Object o);
    E remove(int index);
    E set(int index, E element);


}
