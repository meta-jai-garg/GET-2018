package graphics;

import java.util.Date;

/**
 * Rectangle shape implementation of Shape Interface
 */
public class Rectangle implements Shape {

    private Date timeStamp;
    private Point origin;
    private double length, breadth, originDistance;

    public Rectangle(Point origin, double length, double breadth) {
        this.origin = origin;
        this.length = length;
        this.breadth = breadth;
        this.originDistance = Math.sqrt(Math.pow(origin.getX(), 2) + Math.pow(origin.getY(), 2));

    }

    public Point getPoint() {
        return origin;
    }

    public double getLength() {
        return length;
    }

    public double getBreadth() {
        return breadth;
    }

    @Override
    public double getArea() {
        return length * breadth;
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + breadth);
    }

    @Override
    public Point getOrigin() {
        return new Point(origin.getX(), origin.getY());
    }

    @Override
    public boolean isPointEnclosed(Point point) {
        return point.getX() >origin.getX() && point.getX() < length + origin.getX() && point.getY() > origin.getY() && point.getY() < breadth+origin.getY();
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.RECTANGLE;
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