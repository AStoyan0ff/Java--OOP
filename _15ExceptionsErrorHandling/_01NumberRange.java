package _15ExceptionsErrorHandling;
import java.util.Scanner;

public class _01NumberRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(" ");
        int start = Integer.parseInt(data[0]);
        int end = Integer.parseInt(data[1]);

        System.out.printf("Range: [%d...%d]%n", start, end);

        boolean bValid = false;

        while (!bValid) {
            String input = scanner.nextLine();

            try {
                int N = Integer.parseInt(input);

                if (N >= start && N <= end) {

                    System.out.printf("Valid number: %d%n", N);
                    bValid = true;
                }
                else {
                    System.out.printf("Invalid number: %s%n", input);
                }
            }
            catch (NumberFormatException ex) {
                System.out.printf("Invalid number: %s%n", input);
            }
        }
    }
}
