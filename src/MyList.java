public interface MyList<E> extends Iterable<E> {
    void add(E element);
    void add(E element, int index);
    void addFirst(E element);
    void addLast(E element);
    E getElem(int index);
    E getElemFirst();
    E getElemLast();
    void remove(int index);
    void removeFirst();
    void removeLast();
    int indexOf(Object object);
    int lastIndexOf(Object object);
    boolean exists(Object object);
    void clear();
    int size();
}