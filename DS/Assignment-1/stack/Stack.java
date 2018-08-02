package stack;

import java.util.EmptyStackException;

public interface Stack<E> {

	/**
	 * This method adds element of Type @E in Stack
	 * 
	 * @param e
	 *            is element to be added
	 * @throws StackOverflowError
	 *             in case of {@link StackArray} implementation
	 */
	void push(E e);

	/**
	 * This method delete top element from stack
	 * 
	 * @return popped element of stack
	 * @throws EmptyStackException
	 *             when stack is empty
	 */
	E pop();

	/**
	 * This method return top element from stack
	 * 
	 * @return top element of stack
	 * @throws EmptyStackException
	 *             when stack is empty
	 */
	E peek();

	/**
	 * This method checks whether the stack is empty or not
	 * 
	 * @return true if stack is empty else false
	 */
	boolean isEmpty();

	/**
	 * This method checks whether the stack is
	 * 
	 * @return true if stack is full else false in case of {@link LinkedStack}
	 *         implementation
	 */
	boolean isFull();

}
