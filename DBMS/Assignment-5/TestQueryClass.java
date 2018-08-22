import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TestQueryClass {
	/**
	 * method to test orderByUserID()
	 */
	@Test
	public void testOrderByUserID() {
		List<OrderPojo> resultantPojo = new QueryClass().orderByUserID(34);
		System.out.println(resultantPojo.toString());
	}

	/**
	 * method to test imageBatchInsert()
	 */
	@Test
	public void testImageBatchInsert() {
		int result = new QueryClass().imageBatchInsert();
		assertTrue(result == 5);
	}

	/**
	 * method to test updateProductState
	 */
	@Test
	public void testUpdateProductState() {
		int result = new QueryClass().updateProductState();
		assertTrue(result == 0);
	}

	/**
	 * method to test categoryTitle()
	 */
	@Test
	public void testCategoryTitle() {
		List<CategoryPojo> resultantPojo = new QueryClass().categoryTitle();
		System.out.println(resultantPojo.toString());
	}
}
