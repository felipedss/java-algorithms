package algorithms.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DynamicArrayTest {

    private final DynamicArray dynamicArray = new DynamicArray();

    @BeforeEach
    void init() {
        dynamicArray.push(10);
        dynamicArray.push(15);
        dynamicArray.push(20);
        dynamicArray.push(25);
        dynamicArray.push(30);
        dynamicArray.push(35);
        dynamicArray.push(40);
        dynamicArray.push(45);
        dynamicArray.push(50);
        dynamicArray.push(55);
        dynamicArray.push(60);
    }

    @Test
    void testEmptyArray() {
        DynamicArray dynamicArray = new DynamicArray();
        assertTrue(dynamicArray.isEmpty());
    }

    @Test
    void testGetSizeEmptyArray() {
        DynamicArray dynamicArray = new DynamicArray();
        assertEquals(0, dynamicArray.getSize());
    }

    @Test
    void testGetSize() {
        assertEquals(11, dynamicArray.getSize());
    }

    @Test
    void testAt() {
        assertEquals(35, dynamicArray.at(5));
        assertEquals(60, dynamicArray.at(10));
    }

    @Test
    void testAtWithIndexGreaterThanUsed() {
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.at(80));
    }

    @Test
    void testGetCapacity() {
        assertEquals(16, dynamicArray.getCapacity());
    }

    @Test
    void testInsert() {
        dynamicArray.insert(4, 28);
        assertEquals(28, dynamicArray.at(4));
        assertEquals(30, dynamicArray.at(5));
        assertEquals(12, dynamicArray.getSize());
    }

    @Test
    void testInsertWithResize() {
        dynamicArray.insert(1, 29);
        dynamicArray.insert(2, 30);
        dynamicArray.insert(3, 31);
        dynamicArray.insert(4, 32);
        dynamicArray.insert(4, 33);
        dynamicArray.insert(5, 34);
        assertEquals(32, dynamicArray.getCapacity());
    }

    @Test
    void testInsertWithIndexGreaterThanUsed() {
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.insert(80, 28));
    }

    @Test
    void testPrepend() {
        dynamicArray.preprend(5);
        assertEquals(5, dynamicArray.at(0));
        assertEquals(10, dynamicArray.at(1));
        assertEquals(12, dynamicArray.getSize());
    }

    @Test
    void testPrependWithResize() {
        dynamicArray.preprend(29);
        dynamicArray.preprend(30);
        dynamicArray.preprend(31);
        dynamicArray.preprend(32);
        dynamicArray.preprend(33);
        dynamicArray.preprend(34);
        assertEquals(32, dynamicArray.getCapacity());
    }

    @Test
    void testPopWithResize() {
        DynamicArray dynamicArray = new DynamicArray();
        IntStream.range(0, 32)
                .forEach(dynamicArray::push);
        IntStream.range(0, 30)
                .forEach(v -> dynamicArray.pop());
        assertEquals(8, dynamicArray.getCapacity());
    }

    @Test
    void testPop() {
        int pop = dynamicArray.pop();
        assertEquals(60, pop);
        assertEquals(10, dynamicArray.getSize());
    }

    @Test
    void testDelete() {
        dynamicArray.delete(4);
        assertEquals(10, dynamicArray.getSize());
        assertEquals(35, dynamicArray.at(4));
    }

    @Test
    void testDeleteWithIndexGreaterThanUsed() {
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.delete(80));
    }

    @Test
    void testRemove() {
        dynamicArray.push(35);
        dynamicArray.remove(35);
        assertEquals(10, dynamicArray.getSize());
    }

    @Test
    void testFind() {
        dynamicArray.push(35);
        assertEquals(5, dynamicArray.find(35));
    }

    @Test
    void testFindWithValueNotFound() {
        assertEquals(-1, dynamicArray.find(80));
    }

}
