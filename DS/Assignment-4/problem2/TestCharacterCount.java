package problem2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCharacterCount {

	/**
	 * test for null check
	 */
	@Test(expected = AssertionError.class)
	public void testCountUniqueCharacterNull(){
		CharacterCount.countUniqueCharacter(null);
	}

	/**
	 * test for empty check
	 */
	@Test(expected = AssertionError.class)
	public void testCountUniqueCharacterEmpty(){
		CharacterCount.countUniqueCharacter("");
	}
	
	@Test
	public void test() {
		assertEquals(5, CharacterCount.countUniqueCharacter("abcdddeee"));	
		assertEquals(4, CharacterCount.countUniqueCharacter("abcd"));
		assertEquals(5, CharacterCount.countUniqueCharacter("abcdddeee"));
		assertEquals(1, CharacterCount.countUniqueCharacter(" "));
	}

}
