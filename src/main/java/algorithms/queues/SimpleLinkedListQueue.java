package algorithms.queues;

/**
 * FIFO - First In First Out
 * Implementation using linked-list, with tail pointer
 */
public class SimpleLinkedListQueue<E> {

    private Node head;
    private Node tail;
    private int size;

    class Node {
        E data;
        Node next;
    }

    public SimpleLinkedListQueue() {
        this.size = 0;
    }

    /**
     * bool returns true if empty
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * adds value at position at tail
     *
     * @param value value
     */
    public void enqueue(E value) {
        Node node = new Node();
        node.data = value;

        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        if (head == null) {
            head = tail;
        }
        size++;
    }

    /**
     * returns value and removes least recently added element (front)
     */
    public void dequeue() {
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
    }


}
