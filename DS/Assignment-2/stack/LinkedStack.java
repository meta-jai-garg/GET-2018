package stack;

import java.util.NoSuchElementException;

public class LinkedStack<E> implements Stack<E> {

	private Node<E> top = null;

	private static class Node<E> {
		private E data;
		private Node<E> next;

		public Node(E data) {
			this.data = data;
			next = null;
		}
	}

	@Override
	public void push(E e) {
		Node<E> newNode = new Node<E>(e);
		if (isEmpty()) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack is empty");
		}
		E item = top.data;
		top = top.next;
		return item;
	}

	@Override
	public E peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack is empty");
		}
		return top.data;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public boolean isFull() {
		return false;
	}

}
