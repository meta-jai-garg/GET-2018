package queue;

public class ArrayQueue<E> implements Queue<E> {

	private E[] elements;
	private int front, rear, size;

	/**
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public ArrayQueue(int size) {
		this.size = size;
		elements = (E[]) new Object[size];
		front = -1;
		rear = -1;
	}

	@Override
	public void enqueue(E element) throws QueueException {
		if (isFull()) {
			throw new QueueException("Queue is full");
		}
		if (front == -1) {
			front = 0;
		}
		elements[++rear] = element;
	}

	@Override
	public E dequeue() throws QueueException {
		if (isEmpty() || front > rear) {
			throw new QueueException("Queue is empty");
		}
		return elements[front++];
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
		return front == -1 || front > rear;
	}

	@Override
	public boolean isFull() {
		return rear == size - 1;
	}

}
