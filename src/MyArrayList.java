public class MyArrayList<E> implements MyList<E> {
    private E[] elements;
    private int size;

    public MyArrayList() {  //declaration
        this.elements = (E[]) new Object[5];
        this.size = 0;
    }

    @Override
    public void add(E element) {  //adding new element
        if(size >= elements.length) {
            increaseBuffer();
        }
        elements[size++] = element;
    }

    public void add(E element, int index) {  //adding new element
        if(size >= elements.length) {
            increaseBuffer();
        }
        checkIndex(index);
        elements[index] = element;
    }

    public void addFirst(E element) {  //adding new element as a first element
        add(element, 0);
    }

    public void addLast(E element) {  //adding new element as a last element
        add(element);
    }

    public E getElem(int index) {  //accessing the data
        checkIndex(index);
        return elements[index];
    }

    public E getElemFirst() {  //accessing the data of the first element
        if(size == 0) {
            throw new IllegalStateException("ArrayList is empty");
        }
        return elements[0];
    }

    public E getElemLast() {  //accessing the data of the last element
        if(size == 0) {
            throw new IllegalStateException("ArrayList is empty");
        }
        return elements[size-1];
    }

    public void remove(int index) {  //removing
        checkIndex(index);
        for(int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
    }

    public void removeFirst() {  //removing the first element
        remove(0);
    }

    public void removeLast() {  //removing the last element
        remove(size - 1);
    }

    public int indexOf(Object object) {  //returning the index of the element
        for(int i = 0; i < size; i++) {
            if(object.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object object) {  //returning the index of the last element
        for(int i = size - 1; i >= 0; i--) {
            if(object.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean exists(Object object) {  //checking if the given data exists
        return indexOf(object) != -1;
    }

    public void clear() {  //removing all data
        elements = (E[]) new Object[5];
        size = 0;
    }

    public int size() {
        return size;
    }  //size of an array list

    private void checkIndex(int index) {  //checking the index if it is out of bounds
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is not correct");
        }
    }

    private void increaseBuffer() {
        E[] newElements = (E[]) new Object[elements.length * 2];  //increasing length of an array
        for(int i = 0; i < size; i++) {
            newElements[i] = elements[i];  //coping an array to the new array
        }
        elements = newElements;
    }
}

