package stack;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class TestStackArray {

	@Test()
	public void testPush() {
		Stack<Integer> stack = new StackArray<Integer>(5);
		for (int i = 0; i < 5; i++) {
			stack.push(i + 1);
		}
	}

	@Test(expected = StackOverflowError.class)
	public void testPushException() {
		Stack<Integer> stack = new StackArray<Integer>(5);
		for (int i = 0; i < 5; i++) {
			stack.push(i + 1);
		}
		stack.push(6);
	}

	@Test
	public void testPop() {
		Stack<Integer> stack = new StackArray<Integer>(5);
		for (int i = 0; i < 5; i++) {
			stack.push(i + 1);
		}
		assertSame(5, stack.pop());
	}

	@Test(expected = NoSuchElementException.class)
	public void testPopException() {
		Stack<Integer> stack = new StackArray<Integer>(5);
		for (int i = 0; i < 5; i++) {
			stack.push(i + 1);
		}
		for (int i = 5; i > 0; i--) {
			assertSame(i, stack.pop());
		}
		// exception case
		assertSame(10, stack.pop());
	}

	@Test
	public void testIsEmpty() {
		Stack<Integer> stack = new StackArray<Integer>(5);

		// positive case
		assertTrue(stack.isEmpty());

		stack.push(20);

		// negative case
		assertFalse(stack.isEmpty());
	}

	@Test()
	public void testPeek() {
		Stack<Integer> stack = new StackArray<Integer>(5);
		for (int i = 0; i < 5; i++) {
			stack.push(i + 1);
		}
		assertSame(5, stack.peek());
	}

	@Test(expected = NoSuchElementException.class)
	public void testPeekException() {
		Stack<Integer> stack = new StackArray<Integer>(5);
		assertSame(5, stack.peek());
	}
	
	@Test
	public void testIsFull(){
		Stack<Integer> stack = new StackArray<Integer>(5);
		
		//positive
		assertFalse(stack.isFull());
		for (int i = 0; i < 5; i++) {
			stack.push(i + 1);
		}
		
		//negative
		assertTrue(stack.isFull());
	}

}
