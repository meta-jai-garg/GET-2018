package question1.stackusingarray;

import question1.StackException;
import question1.StackOperations;

public class StackArray implements StackOperations {
    private char[] elements;
    private int stackTop;

    public StackArray(int size) {
        this.elements = new char[size];
        this.stackTop = -1;
    }

    @Override
    public void push(char item) throws StackException {
        if (stackTop == elements.length-1)
            throw new StackException("Stack Overflow");
        elements[++stackTop] = item;
    }

    @Override
    public char pop() throws StackException {
        if (isEmpty())
            throw new StackException("Stack Underflow");
        return elements[stackTop--];
    }

    char top() throws StackException {
        if (isEmpty())
            throw new StackException("Stack is Empty");
        return elements[stackTop];
    }

    @Override
    public boolean isEmpty() {
        return stackTop < 0;
    }
}
