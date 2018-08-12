package priorityqueue;

public class ArrayPriorityQueue implements PriorityQueue {
    private Task[] queue;
    private int rear, front, maxSizeofQueue;

    /**
     * Class Constructor
     *
     * @param maxSizeofQueue max size of queue
     */
    public ArrayPriorityQueue(int maxSizeofQueue) {
        this.maxSizeofQueue = maxSizeofQueue;
        this.queue = new Task[maxSizeofQueue];
        this.front = -1;
        this.rear = -1;
    }

    @Override
    public boolean enqueue(Task task) {
        if (!isFull()) {
            if (front == -1) {
                front++;
                rear++;
            } else {
                rear = (rear + 1) % maxSizeofQueue;
            }
            int position = -1;
            for (int i = front; i <= (rear - 1) % maxSizeofQueue; i++) {
                if (task.getPriority() > queue[i].getPriority()) {
                    position = i;
                    break;
                }
            }
            if (position != -1) {
                for (int i = (rear - 1) % maxSizeofQueue; i >= position; i--) {
                    queue[(i + 1) % maxSizeofQueue] = queue[i];
                }
                queue[position] = task;
            } else {
                queue[rear] = task;
            }
        } else {
            throw new AssertionError("Queue is Full!!!");
        }
        return true;
    }

    @Override
    public Task dequeue() {
        Task task;
        if (isEmpty()) {
            throw new AssertionError("Queue is empty!!!");
        } else {
            if (front == rear) {
                task = queue[front];
                front = -1;
                rear = -1;
            } else {
                task = queue[front];
                front = (front + 1) % maxSizeofQueue;
            }
        }
        return task;
    }

    @Override
    public boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    @Override
    public boolean isFull() {
        return (rear + 1) % maxSizeofQueue == front;
    }
}
