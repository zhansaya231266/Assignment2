public class MyQueueLL<E> {
    private MyLinkedList<E> list;

    public MyQueueLL() {
        list = new MyLinkedList<>();
    }

    public void enqueue(E element) {
        list.add(element);
    }

    public void dequeue() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        list.remove(0);
    }

    public E peek() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.getElem(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}
