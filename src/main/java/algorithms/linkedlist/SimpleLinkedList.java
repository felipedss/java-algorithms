package algorithms.linkedlist;

import java.util.NoSuchElementException;

public class SimpleLinkedList {

    private Node head;

    static class Node {
        int data;
        Node next;
    }

    public void pushFront(int val) {
        head = new Node();
        head.data = val;
    }

    public void pushBack(int val) {
        if (head == null) {
            head = new Node();
            head.data = val;
            return;
        }
        Node node = new Node();
        node.data = val;
        Node copyHead = head;
        while (copyHead.next != null) {
            copyHead = copyHead.next;
        }
        copyHead.next = node;
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
        return copyHead.data;
    }

    public void popFront() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        head = head.next;
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


}
