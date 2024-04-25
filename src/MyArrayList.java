public class MyArrayList<T> implements Mylist<T> {
    private T[] elements;
    private int size;

    public MyArrayList(T[] elements, int size) { //declaration
        this.elements = (T[]) new Object[5];
        this.size = 0;
    }

    @Override
    public void add(T element) { //adding new element
        if(size >= elements.length) {
            increaseBuffer();
        }
        elements[size++] = element;
    }

    public void add(T element, int index) { //adding new element
        if(size >= elements.length) {
            increaseBuffer();
        }
        checkIndex(index);
        elements[index] = element;
    }

    private void increaseBuffer() {
        T[] newElements = (T[]) new Object[elements.length * 2]; //increasing length of an array
        for(int i = 0; i < size; i++) {
            newElements[i] = elements[i]; //coping an array to the new array
        }
        elements = newElements;
    }

    public T getElem(int index) { //accessing the data
        checkIndex(index);
        return elements[index];
    }

    public int size() {
        return size;
    } //size of an array list

    public void printElems() {
        for(int i = 0; i < size; i++) {
            System.out.println(elements[i] + " ");
        }
        System.out.println();
    }

    public void remove(int index) {
        checkIndex(index);
        for(int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
    }

    public void clear() {
        elements = (T[]) new Object[5];
        size = 0;
    }
    private void checkIndex(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is not correct");
        }
    }
}

