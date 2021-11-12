package algorithms.linkedlist;

import java.util.NoSuchElementException;

public class SimpleLinkedList<E> implements ILinkedList<E> {

    private Node<E> head;
    private int size = 0;

    static class Node<E> {
        E data;
        Node<E> next;
    }

    /**
     * adds an item to the front of the list
     *
     * @param val value
     */
    @Override
    public void pushFront(E val) {
        Node<E> node = new Node<>();
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
    @Override
    public void pushBack(E val) {
        if (head == null) {
            pushFront(val);
            return;
        }
        Node<E> node = new Node<>();
        node.data = val;
        Node<E> copyHead = head;
        while (copyHead.next != null) {
            copyHead = copyHead.next;
        }
        copyHead.next = node;
        size++;
    }

    /**
     * removes end item and returns its value
     *
     * @return E
     */
    @Override
    public E popBack() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<E> copyHead = head;
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
    @Override
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
     * @return E
     */
    @Override
    public E front() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    /**
     * get value of end item
     *
     * @return E
     */
    @Override
    public E back() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<E> copyHead = head;
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
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * returns number of data elements in list
     *
     * @return size
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * returns the value of the nth item (starting at 0 for first)
     *
     * @param index index
     * @return E
     */
    @Override
    public E valueAt(int index) {

        if (head == null) {
            throw new NoSuchElementException();
        }

        Node<E> copyHead = head;
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
     * @param val   value
     */
    @Override
    public void insert(int index, E val) {
        if (index > 0 && head == null) {
            throw new NoSuchElementException();
        }
        if (index == 0) {
            pushFront(val);
            return;
        }

        Node<E> node = new Node<>();
        node.data = val;

        Node<E> copyHead = head;
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
    @Override
    public void erase(int index) {
        if (index + 1 > size) {
            throw new NoSuchElementException();
        }
        if (index == 0) {
            popFront();
            return;
        }

        Node<E> current = head;
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
     * @return E
     */
    @Override
    public E valueFromEnd(int index) {
        if (head == null) {
            throw new NoSuchElementException();
        }

        Node<E> current = head;
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
    @Override
    public void reverse() {
        Node<E> current = head;
        Node<E> newHead = null;
        while (current != null) {
            Node<E> node = new Node<>();
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
    @Override
    public void removeValue(E val) {

        if (head == null) {
            throw new NoSuchElementException();
        }

        Node<E> copyHead = head;

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
