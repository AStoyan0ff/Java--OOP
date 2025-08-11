package _01WorkingAbstraction.RhombusStars;
import java.util.Scanner;

public class _01RhombusStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        printFigures(input);
    }

    private static void printFigures(int input) {

        for (int pos = 1; pos <= input; pos++) {
            printRow(input, pos);
        }

        for (int pos = input - 1; pos >= 1; pos--) {
            printRow(input, pos);
        }
    }

    private static void printRow(int R, int cnt) {
        StringBuilder buff = new StringBuilder();

        for (int pos = 0; pos < R - cnt; pos++) {
            buff.append(" ");
        }

        for (int pos = 0; pos < cnt; pos++) {
            buff.append("*");

            if (pos < cnt - 1) {
                buff.append(" ");
            }
        }
        System.out.println(buff);
    }
}
