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
        IntStream.range(0, 11).forEach(dynamicArray::push);
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
        assertEquals(5, dynamicArray.at(5));
        assertEquals(10, dynamicArray.at(10));
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
        assertEquals(4, dynamicArray.at(5));
        assertEquals(12, dynamicArray.getSize());
    }

    @Test
    void testInsertWithResize() {
        IntStream.range(0, 6).forEach(item -> dynamicArray.insert(item, item));
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
        assertEquals(0, dynamicArray.at(1));
        assertEquals(12, dynamicArray.getSize());
    }

    @Test
    void testPrependWithResize() {
        IntStream.range(0, 6).forEach(dynamicArray::preprend);
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
        assertEquals(10, pop);
        assertEquals(10, dynamicArray.getSize());
    }

    @Test
    void testDelete() {
        dynamicArray.delete(4);
        assertEquals(10, dynamicArray.getSize());
        assertEquals(5, dynamicArray.at(4));
    }

    @Test
    void testDeleteWithIndexGreaterThanUsed() {
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.delete(80));
    }

    @Test
    void testRemove() {
        dynamicArray.push(35);
        dynamicArray.remove(35);
        assertEquals(11, dynamicArray.getSize());
    }

    @Test
    void testFind() {
        dynamicArray.push(2);
        assertEquals(2, dynamicArray.find(2));
    }

    @Test
    void testFindWithValueNotFound() {
        assertEquals(-1, dynamicArray.find(80));
    }

}
