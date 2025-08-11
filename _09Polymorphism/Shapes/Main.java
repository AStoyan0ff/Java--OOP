package _09Polymorphism.Shapes;

public class Main {
    public static void main(String[] args) {

        Shape r = new Rectangle(3.00, 4.00);  // Polymorphism
        Shape c = new Circle(5.00);                     // Polymorphism

        System.out.println("Perimeter: " + r.getPerimeter());
        System.out.println("Area: " + r.getArea());

        System.out.println("Perimeter: " + c.getPerimeter());
        System.out.println("Area: " + c.getArea());
    }
}
