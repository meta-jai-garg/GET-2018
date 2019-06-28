package arrayoperations;

import org.junit.Assert;
import org.junit.Test;

public class ArrOperationTest {

	@Test
	public void fixXY() {
		// Assert.assertArrayEquals("Failure", new int[] {},
		// ArrOperations.fixXY(new int[] {}, 4, 5));
		Assert.assertArrayEquals("Failure", new int[] { 1, 4, 5, 1 },
				ArrOperations.fixXY(new int[] { 1, 4, 1, 5 }, 4, 5));
		Assert.assertArrayEquals("Failure", new int[] { 9, 4, 5, 4, 5, 9 },
				ArrOperations.fixXY(new int[] { 5, 4, 9, 4, 9, 5 }, 4, 5));
		Assert.assertArrayEquals("Failure", new int[] { 1, 4, 5, 1, 1, 4, 5 },
				ArrOperations.fixXY(new int[] { 1, 4, 1, 5, 5, 4, 1 }, 4, 5));
		Assert.assertArrayEquals("Failure", new int[3],
				ArrOperations.fixXY(new int[] { 1, 2, 4 }, 4, 5));
	}

	@Test
	public void splitArray() {
		Assert.assertEquals("Failure", 3,
				ArrOperations.splitArray(new int[] { 1, 1, 1, 2, 1 }));
		Assert.assertEquals("Failure", -1,
				ArrOperations.splitArray(new int[] { 2, 1, 1, 2, 1 }));
		Assert.assertEquals("Failure", 1,
				ArrOperations.splitArray(new int[] { 10, 10 }));
	}

	@Test
	public void maxMirror() {
		Assert.assertEquals("Failure", 3,
				ArrOperations.maxMirror(new int[] { 1, 2, 1, 3 }));
		Assert.assertEquals("Failure", 3,
				ArrOperations.maxMirror(new int[] { 1, 2, 3, 7, 8, 3, 2, 1 }));
		Assert.assertEquals("Failure", 2,
				ArrOperations.maxMirror(new int[] { 7, 1, 4, 9, 7, 4, 1 }));
		Assert.assertEquals("Failure", 7,
				ArrOperations.maxMirror(new int[] { 1, 4, 5, 3, 5, 4, 1 }));
	}

	@Test
	public void clumpsInArray() {
		Assert.assertEquals("Failure", 0,
				ArrOperations.clumpsInArray(new int[] { 1, 2, 1, 3 }));
		Assert.assertEquals("Failure", 2,
				ArrOperations.clumpsInArray(new int[] { 1, 2, 2, 3, 4, 4 }));
		Assert.assertEquals("Failure", 2,
				ArrOperations.clumpsInArray(new int[] { 1, 1, 2, 1, 1 }));
		Assert.assertEquals("Failure", 1,
				ArrOperations.clumpsInArray(new int[] { 1, 1, 1, 1, 1 }));
	}
}