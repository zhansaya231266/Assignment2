public class MyStackAL<E> {
    private MyArrayList<E> list;

    public MyStackAL() {
        list = new MyArrayList<>();
    }

    public void push(E element) {
        list.add(element);
    }

    public E peek() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.getElem(list.size() - 1);
    }

    public void pop() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        list.remove(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}
