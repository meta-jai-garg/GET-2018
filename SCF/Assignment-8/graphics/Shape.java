package graphics;

import java.util.Date;

public interface Shape {
	public enum ShapeType {
		SQUARE, RECTANGLE, CIRCLE, TRIANGLE, REGULAR_POLYGON
	}

	/**
	 * This method returns area of defined shape
	 * 
	 * @return area of shape
	 */
	double getArea();

	/**
	 * This method returns perimeter of defined shape
	 * 
	 * @return perimeter of shape
	 */
	double getPerimeter();

	/**
	 * This method returns origin of defined shape
	 * 
	 * @return origin of shape
	 */
	Point getOrigin();

	/**
	 * This method checks whether the given point lies inside the shape or not
	 * 
	 * @param point
	 *            is an object i.e. to be checked
	 * @return true if {@code Point} lies inside the space
	 */
	boolean isPointEnclosed(Point point);

	/**
	 * @return Type of shape
	 */
	public ShapeType getShapeType();

	/**
	 * this method finds distance between origin of screen and shape
	 * 
	 * @return originDistance
	 */
	public double getOriginDistance();

	/**
	 * @return timestamp of shape object
	 */
	public Date getTimestamp();

	/**
	 * 
	 * @param timestamp
	 *            is object add time
	 */
	public void setTimestamp(Date timestamp);
}