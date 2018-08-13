package part1.circularqueue;

import queue.Queue;
import queue.QueueException;

public class CircularQueue<E> implements Queue<E> {
	private E[] elements;
	private int front, rear, size, currentSize;

	/**
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public CircularQueue(int size) {
		this.size = size;
		elements = (E[]) new Object[size];
		front = -1;
		rear = -1;
		currentSize = 0;
	}

	@Override
	public void enqueue(E element) throws QueueException {
		if (isFull()) {
			throw new QueueException("Queue is full");
		} else {
			rear = (rear + 1) % size;
			elements[rear] = element;
			currentSize++;
			if (front == -1) {
				front = rear;
			}
		}
	}

	@Override
	public E dequeue() throws QueueException {
		E frontElement;
		if (isEmpty() || front > rear) {
			throw new QueueException("Queue is empty");
		} else {
			frontElement = elements[front];
			elements[front] = null;
			front = (front + 1) % size;
			currentSize--;
		}
		return frontElement;
	}

	@Override
	public E front() throws QueueException {
		if (isEmpty()) {
			throw new QueueException("Queue is empty");
		}
		return elements[front];
	}

	@Override
	public boolean isEmpty() {
		return currentSize == 0;
	}

	@Override
	public boolean isFull() {
		return currentSize == size;
	}

}
