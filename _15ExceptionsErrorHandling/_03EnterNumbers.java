package _15ExceptionsErrorHandling;
import java.util.Scanner;
import java.util.*;

public class _03EnterNumbers {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = new ArrayList<>();
        
        int start = 1;
        int end = 100;
        
        while (numberList.size() < 10) {

            try {
                int N = readNumber(start, end);
                numberList.add(N);
                start = N;
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid Number!");
            }
            catch (IllegalArgumentException e) {
                System.out.printf("Your number is not in range %d - 100!%n", start);
            }
        }

        System.out.println(String.join(", ", numberList
                .stream()
                .map(String::valueOf)
                .toList()));
    }

    private static int readNumber(int start, int end) {

        String input = SCANNER.nextLine();
        int N;

        try {
            N = Integer.parseInt(input);
        }
        catch (NumberFormatException ex) {
            throw new NumberFormatException();
        }

        if (N <= start || N >= end) {
            throw new IllegalArgumentException();
        }

        return N;
    }
}
