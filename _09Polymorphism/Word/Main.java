package _09Polymorphism.Word;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String initText = scanner.nextLine();
        StringBuilder buff = new StringBuilder(initText);

        CommandInterface commandInterface = Initialization.buildCmdInterface(buff);

        String line;
        while (!(line = scanner.nextLine()).equals("exit")) {

            Command cmd = commandInterface.handle(line);
            cmd.execute(buff);
        }

        System.out.println(buff.toString());
    }
}
