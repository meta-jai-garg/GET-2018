package graphics;

import java.util.Date;

/**
 * Triangle shape implementation of Shape Interface
 */
public class Triangle implements Shape {

	private Point origin;
	private double sideA, sideB, sideC, originDistance, height;
	private Date timeStamp;

	/**
	 * @param origin
	 * @param sideA
	 * @param sideB
	 * @param sideC
	 */
	public Triangle(Point origin, double sideA, double sideB, double sideC,
			double height) {
		this.origin = origin;
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
		this.height = height;
		this.originDistance = Math.sqrt(Math.pow(origin.getX(), 2)
				+ Math.pow(origin.getY(), 2));
	}

	@Override
	public double getArea() {
		double p = getPerimeter() / 2;
		return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
	}

	@Override
	public double getPerimeter() {
		return sideA + sideB + sideC;
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		boolean enclosed = false;
		double base = Math.sqrt(Math.pow(sideC, 2) - Math.pow(height, 2));
		Point b = new Point(origin.getX() + sideA, origin.getY());
		Point c = new Point(origin.getX() + base, origin.getY() + height);

		if (Math.abs(getArea()
				- ((getAreaByVertices(point, origin, b))
						+ getAreaByVertices(point, b, c) + getAreaByVertices(
							point, origin, c))) <= 0.001)
			enclosed = true;

		return enclosed;
	}

	private double getAreaByVertices(Point a, Point b, Point c) {
		return Math
				.abs((a.getX() * (b.getY() - c.getY()) + b.getX()
						* (c.getY() - a.getY()) + c.getX()
						* (a.getY() - b.getY())) / 2.0);
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.TRIANGLE;
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
