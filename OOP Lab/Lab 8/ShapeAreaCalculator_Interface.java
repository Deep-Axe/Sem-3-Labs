import java.util.Scanner;
interface Shape2 {
    double getArea();
}
class Rectangle2 implements Shape2 {
    private double width;
    private double height;

    public Rectangle2(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }
}
class Circle2 implements Shape2 {
    private double radius;

    public Circle2(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}
public class ShapeAreaCalculator_Interface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the width and height of the rectangle:");
        double width = scanner.nextDouble();
        double height = scanner.nextDouble();
        Shape2 rectangle = new Rectangle2(width, height);
        System.out.println("Area of the Rectangle: " + rectangle.getArea());

        System.out.println("Enter the radius of the circle:");
        double radius = scanner.nextDouble();
        Shape2 circle = new Circle2(radius);
        System.out.println("Area of the Circle: " + circle.getArea());

        scanner.close();
    }
}
