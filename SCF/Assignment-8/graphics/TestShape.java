package graphics;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import graphics.Shape.ShapeType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestShape {
	@Test
	public void rectangleTest() {
		Shape rectangle = ShapeFactory.createShape(ShapeType.RECTANGLE,
				new Point(1, 1), Arrays.asList(4, 2));

		assertEquals(8.0, rectangle.getArea(), 0.01);
		assertEquals(12, rectangle.getPerimeter(), 0.01);
		assertFalse(rectangle.isPointEnclosed(new Point(2, 1)));
		assertTrue(rectangle.isPointEnclosed(new Point(4.99, 2)));
	}

	/**
	 * test case for testing the various methods in Square class
	 */
	@Test
	public void squareTest() {
		Shape square = ShapeFactory.createShape(ShapeType.SQUARE, new Point(1,
				1), Arrays.asList(4));

		assertEquals(16.0, square.getArea(), 0.01);
		assertEquals(16.0, square.getPerimeter(), 0.01);
		assertTrue(square.isPointEnclosed(new Point(2, 1.1)));
		assertFalse(square.isPointEnclosed(new Point(5, 5)));
	}

	/**
	 * test case for testing the various methods in Triangle class
	 */
	@Test
	public void triangleTest() {
		Shape triangle = ShapeFactory.createShape(ShapeType.TRIANGLE,
				new Point(1, 1), Arrays.asList(4, 3, 2, 1));

		assertEquals(2.904, triangle.getArea(), 0.001);
		assertEquals(9.0, triangle.getPerimeter(), 0.001);
		assertFalse(triangle.isPointEnclosed(new Point(2, 0)));
		assertFalse(triangle.isPointEnclosed(new Point(4, 2)));
		assertFalse(triangle.isPointEnclosed(new Point(7, 7)));
	}

	/**
	 * test case for testing the various methods in Circle class
	 */
	@Test
	public void circleTest() {
		Shape circle = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(1,
				1), Arrays.asList(4));

		assertEquals(50.265, circle.getArea(), 0.001);
		assertEquals(25.133, circle.getPerimeter(), 0.001);
		assertTrue(circle.isPointEnclosed(new Point(2, 1)));
		assertFalse(circle.isPointEnclosed(new Point(10, 5)));
	}

	/**
	 * test case to add an object to screen
	 */
	@Test
	public void addShapeTest1() {

		Screen screen = new Screen(100, 100);
		Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(
				1, 1), Arrays.asList(4, 2));
		screen.addShape(shape1);
	}

	/**
	 * test case to add an object to screen when object is null
	 */
	@Test(expected = AssertionError.class)
	public void addShapeTest2() {
		Screen screen = new Screen(100, 100);
		screen.addShape(null);
	}

	/**
	 * test case to add an object to screen when shape lies outside the screen
	 */
	@Test(expected = AssertionError.class)
	public void addShapeTest3() {

		Screen screen = new Screen(100, 100);
		Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(
				120, 1), Arrays.asList(4, 2));
		screen.addShape(shape1);
	}

	/**
	 * test case to remove a shape from screen when shape is present
	 */
	@Test
	public void deleteShapeTest1() {

		Screen screen = new Screen(100, 100);
		Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(
				1, 1), Arrays.asList(4, 2));
		screen.addShape(shape1);
		screen.deleteShape(shape1);
	}

	/**
	 * test case to remove a shape from screen when shape is not present
	 */
	@Test(expected = AssertionError.class)
	public void deleteShapeTest2() {

		Screen screen = new Screen(100, 100);
		Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(
				1, 1), Arrays.asList(4, 2));
		screen.addShape(shape1);

		Shape shape2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(
				1, 3), Arrays.asList(5, 2));

		screen.deleteShape(shape2);
		screen.deleteShape(null);
	}

	/**
	 * test case to remove all shapes of a particular type from the screen when
	 * objects of that type are present
	 */
	@Test
	public void deleteShapeTypeTest1() {

		Screen screen = new Screen(100, 100);
		Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(
				1, 1), Arrays.asList(4, 2));
		screen.addShape(shape1);

		Shape shape2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(
				1, 3), Arrays.asList(5, 2));
		screen.addShape(shape2);

		screen.deleteShapeType(ShapeType.RECTANGLE);
	}

	/**
	 * test case to remove all shapes of a particular type from the screen when
	 * no object of that type are present
	 */
	@Test(expected = AssertionError.class)
	public void deleteShapeTypeTest2() {

		Screen screen = new Screen(100, 100);
		Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(
				1, 1), Arrays.asList(4, 2));
		screen.addShape(shape1);

		Shape shape2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(
				1, 3), Arrays.asList(5, 2));
		screen.addShape(shape2);

		Shape shape3 = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(1,
				1), Arrays.asList(4));
		screen.addShape(shape3);

		screen.deleteShapeType(ShapeType.SQUARE);
		screen.deleteShapeType(null);
	}

	/**
	 * test case to sort the shapes on screen according to area
	 */
	@Test
	public void sortByAreaTest1() {

		Screen screen = new Screen(100, 100);
		final Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE,
				new Point(1, 1), Arrays.asList(4, 2));
		screen.addShape(shape1);

		final Shape shape2 = ShapeFactory.createShape(ShapeType.SQUARE,
				new Point(1, 1), Arrays.asList(2));
		screen.addShape(shape2);

		List<Shape> sortedShapeByArea = screen.sortByArea();
		assertEquals(sortedShapeByArea, Arrays.asList(shape2, shape1));
	}

	/**
	 * test case to sort the shapes on screen according to area when no object
	 * is present on screen
	 */
	@Test(expected = AssertionError.class)
	public void sortByAreaTest2() {
		Screen screen = new Screen(100, 100);
		screen.sortByArea();
	}

	/**
	 * test case to sort the shapes on screen according to Parameter
	 */
	@Test
	public void sortByPerimeterTest1() {

		Screen screen = new Screen(100, 100);
		final Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE,
				new Point(1, 1), Arrays.asList(4, 2));
		screen.addShape(shape1);

		final Shape shape2 = ShapeFactory.createShape(ShapeType.SQUARE,
				new Point(1, 1), Arrays.asList(2));
		screen.addShape(shape2);

		List<Shape> sortedShapeByPerimeter = screen.sortByPerimeter();
		assertEquals(sortedShapeByPerimeter, Arrays.asList(shape2, shape1));
	}

	/**
	 * test case to sort the shapes on screen according to Perimeter when no
	 * object is present on screen
	 */
	@Test(expected = AssertionError.class)
	public void sortByPerimeterTest2() {
		Screen screen = new Screen(100, 100);
		screen.sortByPerimeter();
	}

	/**
	 * test case to sort the shapes on screen according to OriginDistance
	 */
	@Test
	public void sortByOriginDistanceTest1() {

		Screen screen = new Screen(100, 100);
		final Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE,
				new Point(1, 1), Arrays.asList(4, 2));
		screen.addShape(shape1);

		final Shape shape2 = ShapeFactory.createShape(ShapeType.SQUARE,
				new Point(2, 1), Arrays.asList(2));
		screen.addShape(shape2);

		final Shape shape3 = ShapeFactory.createShape(ShapeType.CIRCLE,
				new Point(0, 0), Arrays.asList(4));
		screen.addShape(shape3);

		List<Shape> sortedShapeByOriginDistance = screen.sortByOriginDistance();

		assertEquals(sortedShapeByOriginDistance,
				Arrays.asList(shape1, shape2, shape3));
	}

	/**
	 * test case to sort the shapes on screen according to OriginDistance when
	 * no object is present on screen
	 */
	@Test(expected = AssertionError.class)
	public void sortByOriginDistanceTest2() {
		Screen screen = new Screen(100, 100);
		screen.sortByOriginDistance();
	}

	/**
	 * test case to sort the shapes on screen according to Timestamp
	 */
	@Test
	public void sortByTimestampTest1() {

		Screen screen = new Screen(100, 100);
		final Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE,
				new Point(1, 1), Arrays.asList(4, 2));
		screen.addShape(shape1);

		final Shape shape2 = ShapeFactory.createShape(ShapeType.SQUARE,
				new Point(2, 1), Arrays.asList(2));
		screen.addShape(shape2);

		final Shape shape3 = ShapeFactory.createShape(ShapeType.CIRCLE,
				new Point(0, 0), Arrays.asList(4));
		screen.addShape(shape3);

		List<Shape> sortedShapeByTimestamp = screen.sortByTimestamp();
		assertEquals(sortedShapeByTimestamp,
				Arrays.asList(shape1, shape2, shape3));
	}

	/**
	 * test case to sort the shapes on screen according to Timestamp when no
	 * object is present on screen
	 */
	@Test(expected = AssertionError.class)
	public void sortByTimestampTest2() {
		Screen screen = new Screen(100, 100);
		screen.sortByTimestamp();
	}
}
