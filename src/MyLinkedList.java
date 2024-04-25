
public class MyLinkedList<E> implements MyList<E> {
    private class MyNode<E> {
        E data;
        MyNode<E> next;
        MyNode<E> prev;

        public MyNode(E data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    private MyNode<E> head;
    private MyNode<E> tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(E element) {
        MyNode<E> newNode = new MyNode<>(element);
        if(head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public E getElem(int index) {
        checkIndex(index);
        MyNode<E> currentNode = head;
        if(index == 0) {
            return currentNode.data;
        }
        else {
            for(int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        }
        return currentNode.data;
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        checkIndex(index);
        MyNode<E> currentNode = head;
        for(int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        if(currentNode.prev == null) {
            head = currentNode.next;
        }
        else {
            currentNode.next.prev = currentNode.next;
        }
        if(currentNode.next == null) {
            tail = currentNode.prev;
        }
        else {
            currentNode.next.prev = currentNode.prev;
        }
        size--;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is not correct");
        }
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
}
