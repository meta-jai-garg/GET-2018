package graphics;

import java.util.Date;

/**
 * Circle shape implementation of Shape Interface
 */
public class Circle implements Shape {

	private Point origin;
	private double radius;
	private Date timeStamp;
	private double originDistance;

	public Circle(Point origin, double radius) {
		this.origin = origin;
		this.radius = radius;
		this.originDistance = Math.sqrt(Math.pow(getOrigin().getX(), 2)
				+ Math.pow(getOrigin().getY(), 2));
	}

	public Point getPoint() {
		return origin;
	}

	public double getRadius() {
		return radius;
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	@Override
	public Point getOrigin() {
		double x2 = origin.getX();
		double y2 = origin.getY();
		double distance = Math.sqrt(x2 * x2 + y2 * y2);
		double n = radius;
		double m = distance - n;
		double x = m * x2 / (m + n);
		double y = m * y2 / (m + n);
		return new Point(x, y);
	}

	@Override
	public boolean isPointEnclosed(Point p) {
		double xp = p.getX();
		double yp = p.getY();
		double xc = origin.getX();
		double yc = origin.getY();
		double X = Math.abs(xp - xc);
		double Y = Math.abs(yp - yc);
		double distance = Math.sqrt(X * X) + Math.sqrt(Y * Y);
		return distance < radius;
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.CIRCLE;
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