package algorithms.queue;

import algorithms.queues.TaleOfTwoStacks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaleOfTwoStacksTest {

    @Test
    void test1() {
        TaleOfTwoStacks taleOfTwoStacks = new TaleOfTwoStacks(10);
        taleOfTwoStacks.enqueue(42);
        taleOfTwoStacks.dequeue();
        taleOfTwoStacks.enqueue(14);
        Assertions.assertEquals(14, taleOfTwoStacks.peek());
        taleOfTwoStacks.enqueue(28);
        Assertions.assertEquals(14, taleOfTwoStacks.peek());
        taleOfTwoStacks.enqueue(60);
        taleOfTwoStacks.enqueue(78);
        taleOfTwoStacks.dequeue();
        taleOfTwoStacks.dequeue();
    }

    @Test
    void test2() {
        TaleOfTwoStacks taleOfTwoStacks = new TaleOfTwoStacks(5);
        taleOfTwoStacks.enqueue(35);
        taleOfTwoStacks.enqueue(15);
        Assertions.assertEquals(35, taleOfTwoStacks.peek());
        taleOfTwoStacks.dequeue();
        Assertions.assertEquals(15, taleOfTwoStacks.peek());
    }

    @Test
    void test3() {
        TaleOfTwoStacks taleOfTwoStacks = new TaleOfTwoStacks(5);
        taleOfTwoStacks.enqueue(5);
        taleOfTwoStacks.enqueue(10);
        taleOfTwoStacks.enqueue(15);
        taleOfTwoStacks.enqueue(20);
        taleOfTwoStacks.dequeue();
        Assertions.assertEquals(10, taleOfTwoStacks.peek());
    }

    @Test
    void test4() {
        TaleOfTwoStacks taleOfTwoStacks = new TaleOfTwoStacks(5);
        taleOfTwoStacks.dequeue();
        taleOfTwoStacks.dequeue();
        taleOfTwoStacks.dequeue();
        taleOfTwoStacks.enqueue(20);
        Assertions.assertEquals(20, taleOfTwoStacks.peek());
    }
}
