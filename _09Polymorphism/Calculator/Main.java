package _09Polymorphism.Calculator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CalculationEngine engine = new CalculationEngine();
        InputInterpreter interpreter = new InputInterpreter(engine);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.next();

            if ("end".equals(input)) {
                System.out.println(engine.getCurrentResult());
                break;
            }
            interpreter.interpret(input);
        }
    }
}
