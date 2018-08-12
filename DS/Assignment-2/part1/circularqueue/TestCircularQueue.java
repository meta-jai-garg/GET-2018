package part1.circularqueue;

import static org.junit.Assert.*;

import org.junit.Test;

import queue.Queue;
import queue.QueueException;

public class TestCircularQueue {

	@Test()
	public void testEnqueue() {
		Queue<Integer> queue = new CircularQueue<Integer>(5);
		try {
			for (int i = 0; i < 5; i++) {
				queue.enqueue(i + 1);
			}
		} catch (QueueException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test()
	public void testEnqueueException() {
		Queue<Integer> queue = new CircularQueue<Integer>(5);
		try {
			for (int i = 0; i < 6; i++) {
				queue.enqueue(i + 1);
			}
		} catch (QueueException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testDequeue() {
		Queue<Integer> queue = new CircularQueue<Integer>(5);

		try {
			for (int i = 0; i < 5; i++) {
				queue.enqueue(i + 1);
			}
			for (int i = 0; i < 5; i++) {
				assertSame(i + 1, queue.dequeue());
			}

		} catch (QueueException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testDequeueException() {
		Queue<Integer> queue = new CircularQueue<Integer>(5);

		try {
			for (int i = 0; i < 5; i++) {
				queue.enqueue(i + 1);
			}
			for (int i = 0; i < 6; i++) {
				assertSame(i + 1, queue.dequeue());
			}

		} catch (QueueException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testIsEmpty() throws QueueException {
		Queue<Integer> queue = new CircularQueue<Integer>(5);

		// positive case
		assertTrue(queue.isEmpty());

		queue.enqueue(20);

		// negative case
		assertFalse(queue.isEmpty());
	}

	@Test()
	public void testFront() throws QueueException {
		Queue<Integer> queue = new CircularQueue<Integer>(5);
		for (int i = 0; i < 5; i++) {
			queue.enqueue(i + 1);
		}
		assertSame(1, queue.front());
	}

	@Test
	public void testFrontException() {
		Queue<Integer> queue = new CircularQueue<Integer>(5);
		try {
			queue.front();
		} catch (QueueException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testIsFull() throws QueueException {
		Queue<Integer> queue = new CircularQueue<Integer>(5);

		// positive
		assertFalse(queue.isFull());
		for (int i = 0; i < 5; i++) {
			queue.enqueue(i + 1);
		}

		// negative
		assertTrue(queue.isFull());
	}

}
