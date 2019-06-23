package question1;

public interface StackOperations {
    void push(char x) throws StackException;

    char pop() throws StackException;

    boolean isEmpty();
}
