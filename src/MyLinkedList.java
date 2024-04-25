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

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {

    }
}
