package _07InterfacesAbstraction.Ferrari;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputDriver = scanner.nextLine();
        Ferrari ferrari = new Ferrari(inputDriver);

        System.out.println(ferrari);
    }
}
