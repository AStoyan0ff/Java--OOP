package _03Encapsulation.ClassBoxData;

public class Box {

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {

        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public void setLength(double length) {

        if (length <= 0) {
            throw new IllegalStateException("Length cannot be zero or negative.");
        }
        else {
            this.length = length;
        }

    }

    public void setWidth(double width) {

        if (width <= 0) {
            throw new IllegalStateException("Width cannot be zero or negative.");
        }
        else {
            this.width = width;
        }
    }

    public void setHeight(double height) {

        if (height <= 0) {
            throw new IllegalStateException("Height cannot be zero or negative.");
        }
        else {
            this.height = height;
        }

    }

    public double calculateSurfaceArea() {
        return (length * width + length * height + width * height) * 2;
    }

    public double calculateLateralSurfaceArea() {
        return (length * height + width * height) * 2;
    }

    public double calculateVolume() {
        return length * width * height;
    }
}
