package algorithms.linkedlist;

public interface ILinkedList<E> {

    void pushFront(E val);

    void pushBack(E val);

    E popBack();

    void popFront();

    E front();

    E back();

    boolean isEmpty();

    int getSize();

    E valueAt(int index);

    void insert(int index, E val);

    void erase(int index);

    E valueFromEnd(int index);

    void reverse();

    void removeValue(E val);

}
