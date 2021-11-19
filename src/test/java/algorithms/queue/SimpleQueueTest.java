package algorithms.queue;

import algorithms.queues.SimpleLinkedListQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SimpleQueueTest {

    @Test
    void testEmpty() {
        SimpleLinkedListQueue<String> queue = new SimpleLinkedListQueue<>();
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    void testEnqueue() {
        SimpleLinkedListQueue<String> queue = new SimpleLinkedListQueue<>();
        queue.enqueue("aaa");
        queue.enqueue("bbb");
        queue.enqueue("ccc");
        Assertions.assertFalse(queue.isEmpty());
    }

    @Test
    void testDequeue() {
        SimpleLinkedListQueue<String> queue = new SimpleLinkedListQueue<>();
        queue.enqueue("aaa");
        queue.enqueue("bbb");
        queue.enqueue("ccc");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        Assertions.assertTrue(queue.isEmpty());
    }

}
