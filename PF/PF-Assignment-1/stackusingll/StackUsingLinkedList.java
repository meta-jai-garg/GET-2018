package question1.stackusingll;

import question1.StackOperations;
import question1.StackException;

public class StackUsingLinkedList implements StackOperations {
    Node top = null;

    @Override
    public void push(char x) {
        if (isEmpty()) {
            Node newNode = new Node(x);
            top = newNode;
        } else {
            Node newNode = new Node(x);
            newNode.next = top;
            top = newNode;
        }
    }

    @Override
    public char pop() throws StackException {
        if (isEmpty())
            throw new StackException("Underflow Error");
        else {
            char item = top.data;
            top = top.next;
            return item;
        }
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    char top() throws StackException {
        if (isEmpty())
            throw new StackException("Stack is Empty.");
        else
            return top.data;
    }

}
