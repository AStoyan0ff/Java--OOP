package _09Polymorphism.Shapes;

public class Rectangle extends Shape {

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {

        this.height = height;
        this.width = width;

        calculatePerimeter();
        calculateArea();
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    public void setHeight(Double height) {
        this.height = height;

        calculatePerimeter();
        calculateArea();
    }

    public void setWidth(Double width) {
        this.width = width;

        calculatePerimeter();
        calculateArea();
    }

    public void calculatePerimeter() {

        double P = 2 * (height + width);
        setPerimeter(P);
    }

    public void calculateArea() {
        double A = height * width;
        setArea(A);
    }
}
