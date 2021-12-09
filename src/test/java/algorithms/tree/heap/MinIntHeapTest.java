package algorithms.tree.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MinIntHeapTest {

    @Test
    void test() {
        MintIntHeap mintIntHeap = new MintIntHeap(2);
        mintIntHeap.add(10);
        mintIntHeap.add(9);
        mintIntHeap.add(12);
        mintIntHeap.add(15);
        assertEquals(4, mintIntHeap.getSize());
        assertEquals(9, mintIntHeap.peek());
        assertEquals(9, mintIntHeap.poll());
        assertEquals(10, mintIntHeap.peek());
        mintIntHeap.add(8);
        mintIntHeap.add(13);
        assertEquals(8, mintIntHeap.poll());
        assertEquals(10, mintIntHeap.poll());
        assertEquals(12, mintIntHeap.poll());
    }

    @Test
    void testPollEmptyList() {
        MintIntHeap mintIntHeap = new MintIntHeap(2);
        assertThrows(IllegalStateException.class, mintIntHeap::poll);
    }

    @Test
    void testPeekEmptyList() {
        MintIntHeap mintIntHeap = new MintIntHeap(2);
        assertTrue(mintIntHeap.isEmpty());
        assertThrows(IllegalStateException.class, mintIntHeap::peek);
    }

}
