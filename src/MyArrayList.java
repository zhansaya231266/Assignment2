public class MyArrayList<T> implements Mylist<T> {
    private Object[] elements;
    private int size;

    public MyArrayList(Object[] elements, int size) {
        this.elements = (T[]) new Object[5];
        this.size = 0;
    }

    @Override
    public void add(T element) {
        if(size >= elements.length) {
            increaseBuffer();
        }
        elements[size++] = element;
    }

    public void add(T element, int index) {
        if(size >= elements.length) {
            increaseBuffer();
        }
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is not correct");
        }
        elements[index] = element;
    }

    private void increaseBuffer() {
        T[] newElements = (T[]) new Object[elements.length * 2];
        for(int i = 0; i < size; i++) {
            newElements = elements[i];
        }
        elements = newElements;
    }

    public T getElem(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is not correct");
        }
        return elements[index];
    }

    public int size() {
        return size;
    }

    public void printElems() {
        for(int i = 0; i < size; i++) {
            System.out.println(elements[i] + " ");
        }
        System.out.println();
    }

    public void remove(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is not correct");
        }
        for(int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
    }

    public void clear() {
        elements = (T[] new Object[5]);
        size = 0;
    }

}

