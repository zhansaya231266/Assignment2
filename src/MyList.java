public interface MyList<E> extends Iterable<E> {
    void add(E element);
    void add(E element, int index);
    void addFirst(E element);
    void addLast(E element);
    E getElem (int index);
    E getElemFirst();
    E getElemLast() ;
    void remove (int index);
    void removeFirst();
    void removeLast();
    void sort();
    int index0f(Object object);
    int lastIndex0f (Object object);
    boolean exists (Object object);
    public Object[] toArray();
    void clear ();
    int size();
}
