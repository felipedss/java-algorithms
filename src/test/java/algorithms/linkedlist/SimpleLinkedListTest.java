package algorithms.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class SimpleLinkedListTest {

    @Test
    void testEmpty() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        assertTrue(simpleLinkedList.isEmpty());
    }

    @Test
    void testGetSize() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.pushFront(50);
        simpleLinkedList.pushFront(40);
        simpleLinkedList.pushFront(30);
        simpleLinkedList.pushBack(60);
        simpleLinkedList.popFront();
        simpleLinkedList.popBack();
        assertEquals(2, simpleLinkedList.getSize());
    }

    @Test
    void testGetValueAt() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.pushFront(50);
        simpleLinkedList.pushFront(40);
        simpleLinkedList.pushFront(30);
        simpleLinkedList.pushBack(60);
        assertEquals(30, simpleLinkedList.valueAt(0));
        assertEquals(40, simpleLinkedList.valueAt(1));
        assertEquals(50, simpleLinkedList.valueAt(2));
        assertEquals(60, simpleLinkedList.valueAt(3));
    }

    @Test
    void testPushFront() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.pushFront(20);
        simpleLinkedList.pushFront(10);
        assertEquals(10, simpleLinkedList.valueAt(0));
    }

    @Test
    void testPushBack() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.pushBack(10);
        simpleLinkedList.pushBack(20);
        simpleLinkedList.pushBack(30);
        assertEquals(30, simpleLinkedList.valueAt(2));
    }

    @Test
    void testPopFront() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.pushFront(10);
        simpleLinkedList.pushFront(20);
        simpleLinkedList.pushFront(30);
        simpleLinkedList.popFront();
        assertEquals(2, simpleLinkedList.getSize());
        assertEquals(20, simpleLinkedList.valueAt(0));
    }

    @Test
    void testPopBack() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.pushFront(10);
        simpleLinkedList.pushFront(20);
        simpleLinkedList.pushFront(30);
        assertEquals(20, simpleLinkedList.popBack());
        assertEquals(2, simpleLinkedList.getSize());
        assertEquals(30, simpleLinkedList.valueAt(0));
    }

    @Test
    void testPopBackEmptyList() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        assertThrows(NoSuchElementException.class, simpleLinkedList::popBack);
    }

    @Test
    void testPopFrontEmptyList() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        assertThrows(NoSuchElementException.class, simpleLinkedList::popFront);
    }

    @Test
    void testFront() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.pushFront(10);
        simpleLinkedList.pushFront(20);
        simpleLinkedList.pushFront(30);
        assertEquals(3, simpleLinkedList.getSize());
        assertEquals(30, simpleLinkedList.front());
    }

    @Test
    void testBack() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.pushFront(10);
        simpleLinkedList.pushFront(20);
        simpleLinkedList.pushFront(30);
        assertEquals(3, simpleLinkedList.getSize());
        assertEquals(10, simpleLinkedList.back());
    }

    @Test
    void testInsert() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.pushBack(10);
        simpleLinkedList.pushBack(20);
        simpleLinkedList.pushBack(30);
        simpleLinkedList.pushBack(40);
        simpleLinkedList.pushBack(50);
        simpleLinkedList.pushBack(60);

        assertEquals(50, simpleLinkedList.valueAt(4));

        simpleLinkedList.insert(4, 45);

        assertEquals(7, simpleLinkedList.getSize());
        assertEquals(45, simpleLinkedList.valueAt(4));
    }

    @Test
    void testErase() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.pushBack(10);
        simpleLinkedList.pushBack(20);
        simpleLinkedList.pushBack(30);
        simpleLinkedList.pushBack(40);
        simpleLinkedList.pushBack(50);
        simpleLinkedList.pushBack(60);

        assertEquals(50, simpleLinkedList.valueAt(4));

        simpleLinkedList.erase(4);

        assertEquals(5, simpleLinkedList.getSize());
        assertEquals(60, simpleLinkedList.valueAt(4));
    }

    @Test
    void testValueNFromEnd() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.pushBack(10);
        simpleLinkedList.pushBack(20);
        simpleLinkedList.pushBack(30);
        simpleLinkedList.pushBack(40);
        simpleLinkedList.pushBack(50);
        simpleLinkedList.pushBack(60);
        assertEquals(30, simpleLinkedList.valueFromEnd(3));
    }

    @Test
    void testReverse() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.pushBack(10);
        simpleLinkedList.pushBack(20);
        simpleLinkedList.pushBack(30);
        simpleLinkedList.pushBack(40);
        simpleLinkedList.pushBack(50);
        simpleLinkedList.pushBack(60);
        assertEquals(10, simpleLinkedList.valueAt(0));
        assertEquals(20, simpleLinkedList.valueAt(1));
        assertEquals(30, simpleLinkedList.valueAt(2));
        assertEquals(40, simpleLinkedList.valueAt(3));
        assertEquals(50, simpleLinkedList.valueAt(4));
        assertEquals(60, simpleLinkedList.valueAt(5));

        simpleLinkedList.reverse();

        assertEquals(60, simpleLinkedList.valueAt(0));
        assertEquals(50, simpleLinkedList.valueAt(1));
        assertEquals(40, simpleLinkedList.valueAt(2));
        assertEquals(30, simpleLinkedList.valueAt(3));
        assertEquals(20, simpleLinkedList.valueAt(4));
        assertEquals(10, simpleLinkedList.valueAt(5));
    }

    @Test
    void testRemove() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.pushBack(10);
        simpleLinkedList.pushBack(20);
        simpleLinkedList.pushBack(30);
        simpleLinkedList.pushBack(40);
        simpleLinkedList.pushBack(50);
        simpleLinkedList.pushBack(60);
        assertEquals(6, simpleLinkedList.getSize());
        simpleLinkedList.removeValue(20);
        assertEquals(5, simpleLinkedList.getSize());
        assertEquals(30, simpleLinkedList.valueAt(1));
    }

    @Test
    void testRemoveElementNotFound() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.pushBack(10);
        simpleLinkedList.pushBack(20);
        simpleLinkedList.pushBack(30);
        simpleLinkedList.pushBack(40);
        simpleLinkedList.pushBack(50);
        simpleLinkedList.pushBack(60);
        assertThrows(NoSuchElementException.class, () -> simpleLinkedList.removeValue(80));
    }

    @Test
    void testRemoveEmptyList() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        assertThrows(NoSuchElementException.class, () -> simpleLinkedList.removeValue(80));
    }

    @Test
    void testFrontEmptyList() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        assertThrows(NoSuchElementException.class, simpleLinkedList::front);
    }

    @Test
    void testBackEmptyList() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        assertThrows(NoSuchElementException.class, simpleLinkedList::back);
    }

    @Test
    void testValueAtEmptyList() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        assertThrows(NoSuchElementException.class, () -> simpleLinkedList.valueAt(2));
    }

    @Test
    void testValueIndexNotFound() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.pushFront(10);
        assertThrows(NoSuchElementException.class, () -> simpleLinkedList.valueAt(50));
    }

    @Test
    void testInsertEmptyListWithValueGreatherThanZero() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        assertThrows(NoSuchElementException.class, () -> simpleLinkedList.insert(2, 60));
    }

    @Test
    void testInsertInFirstPosition() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.insert(0, 60);
        assertEquals(1, simpleLinkedList.getSize());
    }

    @Test
    void testInsertInLastPosition() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.insert(0, 60);
        simpleLinkedList.insert(0, 50);
        simpleLinkedList.insert(2, 40);
        assertEquals(3, simpleLinkedList.getSize());
    }

    @Test
    void testEraseEmptyList() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        assertThrows(NoSuchElementException.class, () -> simpleLinkedList.erase(0));
    }

    @Test
    void testEraseLastPosition() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.insert(0, 60);
        simpleLinkedList.insert(0, 60);
        simpleLinkedList.erase(1);
        assertEquals(1, simpleLinkedList.getSize());
    }

    @Test
    void testEraseFirstPosition() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.insert(0, 60);
        simpleLinkedList.insert(0, 60);
        simpleLinkedList.erase(0);
        assertEquals(1, simpleLinkedList.getSize());
    }

    @Test
    void testEraseIndexNotFound() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.insert(0, 60);
        simpleLinkedList.insert(0, 60);
        assertThrows(NoSuchElementException.class, () -> simpleLinkedList.erase(100));
    }

    @Test
    void testValueFromEndEmptyList() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        assertThrows(NoSuchElementException.class, () -> simpleLinkedList.valueFromEnd(0));
    }


    @Test
    void testValueFromEndIndexNotFound() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.insert(0, 60);
        assertThrows(NoSuchElementException.class, () -> simpleLinkedList.valueFromEnd(200));
    }

    @Test
    void testRemoveFirstElement() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.pushBack(10);
        simpleLinkedList.pushBack(20);
        simpleLinkedList.pushBack(30);
        simpleLinkedList.pushBack(40);
        simpleLinkedList.pushBack(50);
        simpleLinkedList.pushBack(60);
        simpleLinkedList.removeValue(10);
        assertEquals(5, simpleLinkedList.getSize());
    }

    @Test
    void testRemoveLastElement() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.pushBack(10);
        simpleLinkedList.pushBack(20);
        simpleLinkedList.pushBack(30);
        simpleLinkedList.pushBack(40);
        simpleLinkedList.pushBack(50);
        simpleLinkedList.pushBack(60);
        simpleLinkedList.removeValue(60);
        assertEquals(5, simpleLinkedList.getSize());
        assertEquals(50, simpleLinkedList.valueAt(4));
    }

}
