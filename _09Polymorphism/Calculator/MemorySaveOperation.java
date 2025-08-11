package _09Polymorphism.Calculator;

import java.util.ArrayDeque;

public class MemorySaveOperation implements Operation {

    private CalculationEngine engine;
    private ArrayDeque<Integer> memoryStack;

    public MemorySaveOperation(CalculationEngine engine, ArrayDeque<Integer> memoryStack) {
        this.engine = engine;
        this.memoryStack = memoryStack;
    }

    @Override
    public void execute(int operand) {
        memoryStack.push(engine.getCurrentResult());
    }
}
