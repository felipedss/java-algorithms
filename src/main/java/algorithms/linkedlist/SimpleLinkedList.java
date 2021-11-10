package algorithms.linkedlist;

import java.util.NoSuchElementException;

public class SimpleLinkedList {

    private Node head;
    private int size = 0;

    static class Node {
        int data;
        Node next;
    }

    public void pushFront(int val) {
        Node node = new Node();
        node.data = val;
        node.next = head;
        head = node;
        size++;
    }

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

    public void popFront() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        head = head.next;
        size--;
    }

    public int front() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

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

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public int valueAt(int index) {

        if (head == null) {
            throw new NoSuchElementException();
        }

        Node newNode = head;
        int count = 0;
        do {
            if (count == index) {
                return newNode.data;
            }
            count++;
            newNode = newNode.next;
        } while (newNode != null);
        throw new NoSuchElementException();
    }

    public void insert(int index, int val) {
        if (index > 0 && head == null) {
            throw new NoSuchElementException();
        }
        if (index == 0) {
            pushFront(val);
            return;
        }
        if (index == size) {
            pushBack(val);
            return;
        }

        Node node = new Node();
        node.data = val;

        Node current = head;
        int counter = 0;
        while (current != null) {
            if (counter + 1 == index) {
                node.next = current.next;
                current.next = node;
                break;
            }
            counter++;
            current = current.next;
        }
        size++;
    }

    public void erase(int index) {
        if (index > size) {
            throw new NoSuchElementException();
        }
        if (index == size) {
            popBack();
            return;
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

}
