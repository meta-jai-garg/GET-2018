package graphics;

import java.util.Date;

/**
 * Regular Polygon shape implementation of Shape Interface
 */
public class RegularPolygon implements Shape {

	private Point origin;
	private double length;
	private int noOfSide;
	private double originDistance;
	private Date timeStamp;

	public RegularPolygon(Point origin, double length, int noOfSide) {
		this.origin = origin;
		this.length = length;
		this.noOfSide = noOfSide;
		this.originDistance = Math.sqrt(Math.pow(origin.getX(), 2)
				+ Math.pow(origin.getY(), 2));
	}

	@Override
	public double getArea() {
		double apothem = length
				/ (2 * Math.tan(Math.toRadians(180 / noOfSide)));
		return 0.5 * apothem * getPerimeter();
	}

	@Override
	public double getPerimeter() {
		return length * noOfSide;
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		return false;
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.REGULAR_POLYGON;
	}

	@Override
	public double getOriginDistance() {
		return originDistance;
	}

	@Override
	public Date getTimestamp() {
		return timeStamp;
	}

	@Override
	public void setTimestamp(Date timestamp) {
		this.timeStamp = timestamp;
	}

}
