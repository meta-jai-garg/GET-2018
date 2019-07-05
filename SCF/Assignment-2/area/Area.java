package area;

/**
 * This class computes area of various shapes
 * 1. Triangle
 * 2. Rectangle
 * 3. Square
 * 4. Circle
 *
 * @author Jai Kumar Garg
 */
class Area {

    /**
     * This method computes area of a Triangle using formula
     * Area of Triangle = 0.5 * width * height
     *
     * @param width  is the width of triangle requires width > 0
     * @param height is the height of triangle requires height > 0
     * @return area of triangle
     */
    double areaOfTriangle(double width, double height) {
        return width * height * 0.5;
    }

    /**
     * This method computes area of a Rectangle using formula
     * Area of Rectangle = 2 * (width + height)
     *
     * @param width  is the width of rectangle requires width > 0
     * @param height is the height of rectangle requires height > 0
     * @return area of rectangle
     */
    double areaOfRectangle(double width, double height) {
        return 2 * (width + height);
    }

    /**
     * This method computes area of a Square using formula
     * Area of Square = width * width
     *
     * @param width is the width of rectangle requires width > 0
     * @return area of square
     */
    double areaOfSquare(double width) {
        return width * width;
    }

    /**
     * This method computes area of a Circle using formula
     * Area of Circle = 3.14 * radius * radius
     *
     * @param radius is the radius of circle requires
     * @return area of circle
     */
    double areaOfCircle(double radius) {
        return 3.14 * radius * radius;
    }
}
