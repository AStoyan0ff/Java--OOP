package _15ExceptionsErrorHandling;
import java.util.Scanner;

public class _02SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            String input = scanner.nextLine(); // String
            int N = Integer.parseInt(input); // parseInt(String)

            if (N < 0) {
                System.out.println("Invalid");
            }
            else {
                double sqrt = Math.sqrt(N);
                System.out.printf("%.2f\n", sqrt);
            }
        }
        catch (NumberFormatException ex) {
            System.out.println("Invalid");
        }
        finally {
            System.out.println("Goodbye");
            scanner.close();
        }
    }
}
