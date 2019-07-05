package area;

import java.util.Scanner;

public class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Area area = new Area();
        while (true) {
            System.out.println("1. Area of Triangle");
            System.out.println("2. Area of Rectangle");
            System.out.println("3. Area of Square");
            System.out.println("4. Area of Circle");
            System.out.println("5. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter width and height of Triangle");
                    double width = sc.nextDouble();
                    double height = sc.nextDouble();
                    System.out.println("Area of Triangle is : " + area.areaOfTriangle(width, height));
                    break;
                }
                case 2: {
                    System.out.println("Enter width and height of Rectangle");
                    double width = sc.nextDouble();
                    double height = sc.nextDouble();
                    System.out.println("Area of Rectangle is : " + area.areaOfRectangle(width, height));
                    break;
                }
                case 3: {
                    System.out.println("Enter width of Square");
                    double width = sc.nextDouble();
                    System.out.println("Area of Square is : " + area.areaOfSquare(width));
                    break;
                }
                case 4: {
                    System.out.println("Enter radius of Circle");
                    double radius = sc.nextDouble();
                    System.out.println("Area of Circle is : " + area.areaOfCircle(radius));
                    break;
                }
                case 5: {
                    System.exit(0);
                }
                default: {
                    System.out.println("Wrong Choice");
                }
            }
        }
    }
}
