package _09Polymorphism.Shapes;

public class Circle extends  Shape {

    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public void calculatePerimeter() {

        double p = 2 * Math.PI * radius;
        setPerimeter(p);
    }

    public void calculateArea() {

        double s = Math.PI * radius * radius;
        setArea(s);
    }
}
