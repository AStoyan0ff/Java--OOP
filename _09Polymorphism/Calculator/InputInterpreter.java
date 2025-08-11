package _09Polymorphism.Calculator;

import java.util.ArrayDeque;

public class InputInterpreter {

    private CalculationEngine engine;
    private ArrayDeque<Integer> memoryStack;
    private Operation currOperation;

    public InputInterpreter(CalculationEngine engine) {
        this.engine = engine;
        this.memoryStack = new ArrayDeque<>();
    }

    public void interpret(String input) {

        switch (input) {

            case "*":
                currOperation = new MultiplicationOperation(engine);
                break;

            case "/":
                currOperation = new DivisionOperation(engine);
                break;

            case "ms":
                memoryStack.push(engine.getCurrentResult());
                break;

            case "mr":
                if (currOperation != null) {
                    currOperation.execute(memoryStack.pop());
                    currOperation = null;
                }
                else {
                    engine.pushOperand(memoryStack.pop());
                }
                break;

            default:
                int value = Integer.parseInt(input);

                if (currOperation == null) {
                    engine.pushOperand(value);
                }
                else {
                    currOperation.execute(value);
                    currOperation = null;
                }
        }
    }
}
