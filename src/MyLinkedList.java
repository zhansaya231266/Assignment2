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

    public MyLinkedList() {  //declaration
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(E element) {  //adding a new Node when tail is stored
        MyNode<E> newMyNode = new MyNode<>(element);
        if(head == null) {
            head = newMyNode;
            tail = newMyNode;
        }
        else {
            tail.next = newMyNode;
            newMyNode.prev = tail;
            tail = newMyNode;
        }
        size++;
    }

    public void add(E element, int index) {  //adding new Node
        checkIndex(index);
        if(index == size) {
            add(element);
        }
        MyNode<E> newMyNode = new MyNode<>(element);
        if(index == 0) {
            newMyNode.next = head;
            if(head != null) {
                head.prev = newMyNode;
            }
            head = newMyNode;
        }
        else {
            MyNode<E> currentNode = (MyNode<E>) new MyNode<>(index);
            newMyNode.next = currentNode;
            newMyNode.prev = currentNode.prev;
            currentNode.prev.next = newMyNode;
            currentNode.prev = newMyNode;
        }
        size++;
    }

    public void addFirst(E element) {  //adding new element as a first element
        add(element, 0);
    }

    public void addLast(E element) {  //adding new element as a last element
        add(element);
    }

    public E getElem(int index) {  //retrieving the data
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

    public E getElemFirst() {  //accessing the data of the first element
        return head.data;
    }

    public E getElemLast() {  //accessing the data of the last element
        return tail.data;
    }

    public void remove(int index) {  //removing
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

    public void removeFirst() {  //removing the first Node
        head = head.next;
        if(head == null) {
            tail = null;
        }
        else {
            head.prev = null;
        }
        size--;
    }

    public void removeLast() {  //removing the last Node
        tail = tail.prev;
        if(tail == null) {
            head = null;
        }
        else {
            tail.next = null;
        }
        size--;
    }

    public int indexOf(Object object) {  //returning the index of the Node
        int index = 0;
        MyNode<E> currentNode = head;
        while(currentNode != null) {
            if(object.equals(currentNode.data)) {
                return index;
            }
            currentNode = currentNode.next;
            index++;
        }
        return -1;
    }

    public int lastIndexOf(Object object) {  //returning the index of the last Node
        int lastIndex = -1;
        int index = 0;
        MyNode<E> currentNode = head;
        while(currentNode != null) {
            if(object.equals(currentNode.data)) {
                lastIndex = index;
            }
            currentNode = currentNode.next;
            index++;
        }
        return lastIndex;
    }

    public boolean exists(Object object) {  //checking if the given data exists
        return indexOf(object) != -1;
    }

    public void clear() {  //removing all data
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {  //getting size
        return size;
    }

    private void checkIndex(int index) {  //checking the index if it is out of bounds
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is not correct");
        }
    }

    public void swap(int i, int j) {
        MyNode currentI = head;
        MyNode currentJ = head;
        for (int index = 0; index < j; index++) {
            if (index < i) {
                currentI = currentI.next;
            }
            currentJ = currentJ.next;
        }
        E tempData = (E) currentI.data;
        currentI.data = currentJ.data;
        currentJ.data = tempData;
    }
}
