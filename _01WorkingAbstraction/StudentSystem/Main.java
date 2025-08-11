package _01WorkingAbstraction.StudentSystem;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentSystem studentSystem = new StudentSystem();

        String cmd = scanner.nextLine();
        while (!cmd. equals("Exit")) {

            String[] input = cmd.split(" ");
            studentSystem.parseCommand(input);

            cmd = scanner.nextLine();
        }
    }
}
