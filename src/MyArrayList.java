public class MyArrayList<E> implements MyList<E> {
    private E[] elements;
    private int size;

    public MyArrayList(E[] elements, int size) { //declaration
        this.elements = (E[]) new Object[5];
        this.size = 0;
    }

    @Override
    public void add(E element) { //adding new element
        if(size >= elements.length) {
            increaseBuffer();
        }
        elements[size++] = element;
    }

    public void add(E element, int index) { //adding new element
        if(size >= elements.length) {
            increaseBuffer();
        }
        checkIndex(index);
        elements[index] = element;
    }

    private void increaseBuffer() {
        E[] newElements = (E[]) new Object[elements.length * 2]; //increasing length of an array
        for(int i = 0; i < size; i++) {
            newElements[i] = elements[i]; //coping an array to the new array
        }
        elements = newElements;
    }

    public E getElem(int index) { //accessing the data
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
        elements = (E[]) new Object[5];
        size = 0;
    }
    private void checkIndex(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is not correct");
        }
    }
}

