package algorithms.linkedlist;

import java.util.NoSuchElementException;

/**
 * A simple linked list implementation without tail.
 */
public class SimpleLinkedList {

    private Node head;
    private int size = 0;

    static class Node {
        int data;
        Node next;
    }

    /**
     * adds an item to the front of the list
     *
     * @param val value
     */
    public void pushFront(int val) {
        Node node = new Node();
        node.data = val;
        node.next = head;
        head = node;
        size++;
    }

    /**
     * adds an item at the end
     *
     * @param val value
     */
    public void pushBack(int val) {
        if (head == null) {
            pushFront(val);
            return;
        }
        Node node = new Node();
        node.data = val;
        Node copyHead = head;
        while (copyHead.next != null) {
            copyHead = copyHead.next;
        }
        copyHead.next = node;
        size++;
    }

    /**
     * removes end item and returns its value
     *
     * @return int
     */
    public int popBack() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node copyHead = head;
        while (copyHead.next.next != null) {
            copyHead = copyHead.next;
        }
        copyHead.next = null;
        size--;
        return copyHead.data;
    }

    /**
     * remove front item and return its value
     */
    public void popFront() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        head = head.next;
        size--;
    }

    /**
     * get value of front item
     *
     * @return int
     */
    public int front() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    /**
     * get value of end item
     *
     * @return int
     */
    public int back() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node copyHead = head;
        while (copyHead.next != null) {
            copyHead = copyHead.next;
        }
        return copyHead.data;
    }

    /**
     * bool returns true if empty
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * returns number of data elements in list
     *
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * returns the value of the nth item (starting at 0 for first)
     *
     * @param index index
     * @return int
     */
    public int valueAt(int index) {

        if (head == null) {
            throw new NoSuchElementException();
        }

        Node copyHead = head;
        int count = 0;
        do {
            if (count == index) {
                return copyHead.data;
            }
            count++;
            copyHead = copyHead.next;
        } while (copyHead != null);
        throw new NoSuchElementException();
    }

    /**
     * insert value at index, so current item at that index is pointed to by new item at index
     *
     * @param index index
     * @param val value
     */
    public void insert(int index, int val) {
        if (index > 0 && head == null) {
            throw new NoSuchElementException();
        }
        if (index == 0) {
            pushFront(val);
            return;
        }

        Node node = new Node();
        node.data = val;

        Node copyHead = head;
        int counter = 0;
        while (copyHead != null) {
            if (counter + 1 == index) {
                node.next = copyHead.next;
                copyHead.next = node;
                break;
            }
            counter++;
            copyHead = copyHead.next;
        }
        size++;
    }

    /**
     * removes node at given index
     *
     * @param index index
     */
    public void erase(int index) {
        if (index + 1 > size) {
            throw new NoSuchElementException();
        }
        if (index == 0) {
            popFront();
            return;
        }

        Node current = head;
        int counter = 0;
        while (current != null) {
            if (counter + 1 == index) {
                current.next = current.next.next;
                break;
            }
            counter++;
            current = current.next;
        }
        size--;
    }

    /**
     * returns the value of the node at nth position from the end of the list
     *
     * @param index index
     * @return int
     */
    public int valueFromEnd(int index) {
        if (head == null) {
            throw new NoSuchElementException();
        }

        Node current = head;
        int count = 0;
        while (current != null) {
            if (count + 1 == (size - index)) {
                return current.data;
            }
            count++;
            current = current.next;
        }
        throw new NoSuchElementException();
    }

    /**
     * reverses the list
     */
    public void reverse() {
        Node current = head;
        Node newHead = null;
        while (current != null) {
            Node node = new Node();
            node.data = current.data;
            node.next = newHead;
            newHead = node;
            current = current.next;
        }
        head = newHead;
    }

    /**
     * removes the first item in the list with this value
     *
     * @param val value
     */
    public void removeValue(int val) {

        if (head == null) {
            throw new NoSuchElementException();
        }

        Node copyHead = head;

        if (copyHead.data == val) {
            head = copyHead.next;
            size--;
            return;
        }

        while (copyHead.next != null) {
            if (copyHead.next.data == val) {
                if (copyHead.next.next == null) {
                    copyHead.next = null;
                } else {
                    copyHead.next = copyHead.next.next;
                }
                size--;
                return;
            }
            copyHead = copyHead.next;
        }
        throw new NoSuchElementException();
    }

}
