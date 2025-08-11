package _09Polymorphism.MathOperation;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        // Compile time Polymorphism
        System.out.println(MathOperation.add(2, 2));              // 4
        System.out.println(MathOperation.add(3, 3, 3));        // 9
        System.out.println(MathOperation.add(4, 4, 4, 4)); // 16
    }
}
