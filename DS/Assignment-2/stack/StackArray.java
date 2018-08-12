package stack;

import java.util.NoSuchElementException;

public class StackArray<E> implements Stack<E> {

	private E[] elements;
	private int size;
	private int top;

	/**
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public StackArray(int size) {
		this.size = size;
		elements = (E[]) new Object[size];
		top = -1;
	}

	@Override
	public void push(E e) {
		if (isFull()) {
			throw new StackOverflowError("Overflow Error");
		}
		elements[++top] = e;
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack Underflow");
		} else {
			return elements[top--];
		}
	}

	@Override
	public E peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack is Empty");
		}
		return elements[top];
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public boolean isFull() {
		return top == size - 1;
	}

}
