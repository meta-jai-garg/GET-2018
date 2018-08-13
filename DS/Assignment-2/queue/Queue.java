package queue;

public interface Queue<E> {
	/**
	 * this method add specific element to queue
	 * 
	 * @param element
	 *            to be added
	 * @throws QueueException
	 *             in case of {@link ArrayQueue} implementation
	 */
	void enqueue(E element) throws QueueException;

	/**
	 * this method removes element from queue
	 * 
	 * @return deleted element from queue
	 * @throws QueueException
	 */
	E dequeue() throws QueueException;

	/**
	 * this method gives front element of queue
	 * 
	 * @return front element from queue
	 * @throws QueueException
	 */
	E front() throws QueueException;

	/**
	 * this method checks whether the queue is empty or not
	 * 
	 * @return true if queue is empty
	 */
	boolean isEmpty();

	/**
	 * this method checks whether the queue is full or not
	 * 
	 * @return true if queue is full else false and in case of
	 *         {@code LinkedQueue} will always return false
	 */
	boolean isFull();
}
