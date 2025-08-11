package _01WorkingAbstraction.PointRectangle;

import java.util.*;

class Point {

    private int x;
    private  int y;

    public Point(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}

class Rectangle {

    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {

        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point p) {

        return p.getX() >= bottomLeft.getX()
                && p.getX() <= topRight.getX()
                && p.getY() >= bottomLeft.getY()
                && p.getY() <= topRight.getY();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        Point bottomLeft = new Point(x1, y1);
        Point topRight = new Point(x2, y2);
        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int N = scanner.nextInt();

        accessPoints(N, scanner, rectangle);

        scanner.close();
    }

    private static void accessPoints(int N, Scanner scanner, Rectangle rectangle) {

        for (int pos = 0; pos < N; pos++) {

            int x = scanner.nextInt();
            int y = scanner.nextInt();

            Point point = new Point(x, y);
            System.out.println(rectangle.contains(point));
        }
    }
}