package graphics;

import java.util.Date;

/**
 * Square shape implementation of Shape Interface
 */
public class Square implements Shape {
	private Date timeStamp;
	private Point origin;
	private double side, originDistance;

	public Square(Point origin, double side) {
		this.origin = origin;
		this.side = side;
		this.originDistance = Math.sqrt(Math.pow(origin.getX(), 2)
				+ Math.pow(origin.getY(), 2));
	}

	@Override
	public double getArea() {
		return side * side;
	}

	@Override
	public double getPerimeter() {
		return 4 * side;
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		return point.getX() > origin.getX()
				&& point.getX() < side + origin.getX()
				&& point.getY() > origin.getY()
				&& point.getY() < side + origin.getY();
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.SQUARE;
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