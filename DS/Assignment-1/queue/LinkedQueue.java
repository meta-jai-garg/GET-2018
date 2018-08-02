package queue;

public class LinkedQueue<E> implements Queue<E> {
	private Node<E> front, rear;

	private static class Node<E> {
		private E data;
		private Node<E> next;

		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}

	@Override
	public void enqueue(E element) {
		Node<E> newElement = new Node<E>(element);
		if (front == null) {
			front = newElement;
		} else {
			if (front.next == null) {
				front.next = newElement;
			} else {
				rear.next = newElement;
			}
			rear = newElement;
		}
	}

	@Override
	public E dequeue() throws QueueException {
		if (isEmpty()) {
			throw new QueueException("Queue is empty");
		}
		E data = front.data;
		front = front.next;
		return data;
	}

	@Override
	public E front() throws QueueException {
		if (isEmpty()) {
			throw new QueueException("Queue is empty");
		}
		return front.data;
	}

	@Override
	public boolean isEmpty() {
		return front == null;
	}

	@Override
	public boolean isFull() {
		return false;
	}
}
