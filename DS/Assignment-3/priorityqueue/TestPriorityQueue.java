package priorityqueue;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestPriorityQueue {
    /**
     * test case to enqueue a value in queue (return true when element is enqueued and returns false when queue is full)
     */
    @Test
    public void PriorityQueueEnqueueTest() {
        PriorityQueue queue = new ArrayPriorityQueue(5);
        assertTrue(queue.enqueue(new Task("Task 1", 2)));
        assertTrue(queue.enqueue(new Task("Task 2", 5)));
        assertTrue(queue.enqueue(new Task("Task 3", 4)));
        assertTrue(queue.enqueue(new Task("Task 4", 1)));
        assertTrue(queue.enqueue(new Task("Task 5", 1)));
    }

    /**
     * test case to dequeue a value from the queue
     */
    @Test
    public void PriorityQueueDequeueTest1() {
        PriorityQueue queue = new ArrayPriorityQueue(5);
        queue.enqueue(new Task("Task 2", 2));
        queue.enqueue(new Task("Task 3", 1));
        queue.enqueue(new Task("Task 4", 5));
        assertEquals("Task 4", queue.dequeue().getTask());
        queue.enqueue(new Task("Task 6", 6));
        assertEquals("Task 6", queue.dequeue().getTask());
    }

    /**
     * test case to dequeue a value from the queue when it is empty
     */
    @Test(expected = AssertionError.class)
    public void PriorityQueueDequeueTest2() {
        PriorityQueue queue = new ArrayPriorityQueue(5);
        queue.enqueue(new Task("Task 2", 2));
        queue.dequeue();
        queue.dequeue();
    }

    /**
     * test case to check if the queue is empty when actually the queue is not empty
     */
    @Test
    public void PriorityQueueIsEmptyTest1() {
        PriorityQueue queue = new ArrayPriorityQueue(5);
        queue.enqueue(new Task("Task 2", 2));
        assertFalse(queue.isEmpty());
    }

    /**
     * test case to check if the queue is empty when actually the queue is empty
     */
    @Test
    public void PriorityQueueIsEmptyTest2() {
        PriorityQueue queue = new ArrayPriorityQueue(5);
        assertTrue(queue.isEmpty());
    }

    /**
     * test case to check if the queue is full when actually the queue is full
     */
    @Test
    public void PriorityQueueIsFullTest1() {
        PriorityQueue queue = new ArrayPriorityQueue(5);
        assertTrue(queue.enqueue(new Task("Task 1", 2)));
        assertTrue(queue.enqueue(new Task("Task 2", 5)));
        assertTrue(queue.enqueue(new Task("Task 3", 4)));
        assertTrue(queue.enqueue(new Task("Task 4", 1)));
        assertTrue(queue.enqueue(new Task("Task 5", 1)));
        assertTrue(queue.isFull());
    }


    /**
     * test case to check if the queue is full when actually the queue is not full
     */
    @Test
    public void PriorityQueueIsFullTest2() {
        PriorityQueue queue = new ArrayPriorityQueue(5);
        assertFalse(queue.isFull());

        queue.enqueue(new Task("Task 1", 2));
        assertFalse(queue.isFull());
        assertTrue(queue.enqueue(new Task("Task 2", 5)));
        assertTrue(queue.enqueue(new Task("Task 3", 4)));
        assertTrue(queue.enqueue(new Task("Task 4", 1)));
        assertTrue(queue.enqueue(new Task("Task 5", 1)));
        assertTrue(queue.isFull());
        queue.dequeue();
        queue.dequeue();
        assertFalse(queue.isFull());
    }
}