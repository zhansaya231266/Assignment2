public class MyMinHeapLL<E> {
    private MyLinkedList<E> heap;

    public MyMinHeapLL() {
        heap = new MyLinkedList<>();
    }

    public void insert(E element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    public E delete() {
        if(isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        E min = heap.getElem(0);
        int lastIndex = heap.size() - 1;
        heap.remove(lastIndex);
        if(!isEmpty()) {
            heapifyDown(0);
        }
        return min;
    }

    public E get() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.getElem(0);
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        while(index > 0) {
            heap.swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int minind = index;

        if (rightChild < heap.size()) {
            minind = leftChild;
        }
        if (rightChild < heap.size()) {
            minind = rightChild;
        }
        if (minind != index) {
            heap.swap(index, minind);
            heapifyDown(minind);
        }
    }
}
