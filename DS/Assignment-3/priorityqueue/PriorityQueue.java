package priorityqueue;

public interface PriorityQueue {
    /**
     * Method to insert task into queue
     * @param task is an object of {@link Task}
     * @return true when task is successfully added to queue
     */
    boolean enqueue(Task task);

    /**
     * Method to remove task from queue
     * @return {@link Task} object that is removed
     */
    Task dequeue();

    /**
     * Checks whether queue empty or not
     * @return true in case of empty queue
     */
    boolean isEmpty();

    /**
     * checks whether queue is full or not
     * @return true when queue is full
     */
    boolean isFull();
}
