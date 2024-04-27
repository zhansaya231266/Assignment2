public class MyStackLL<E> {
    private MyLinkedList<E> list;

    public MyStackLL() {
        list = new MyLinkedList<>();
    }

    public void push(E element) {
        list.addLast(element);
    }

    public E peek() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.getElemLast();
    }

    public E pop() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        E element = list.getElemLast();
        list.removeLast();
        return element;
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}
