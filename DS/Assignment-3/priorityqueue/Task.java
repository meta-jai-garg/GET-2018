package priorityqueue;

public class Task {
    private String task;
    private int priority;

    /**
     * Class constructor
     *
     * @param task     name of task
     * @param priority is priority of Task
     */
    public Task(String task, int priority) {
        this.task = task;
        this.priority = priority;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "task='" + task + '\'' +
                ", priority=" + priority +
                '}';
    }
}
