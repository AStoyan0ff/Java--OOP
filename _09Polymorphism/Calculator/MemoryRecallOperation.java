package _09Polymorphism.Calculator;

import java.util.ArrayDeque;

public class MemoryRecallOperation implements Operation {

    private CalculationEngine engine;
    private ArrayDeque<Integer> memoryStack;

    public MemoryRecallOperation(CalculationEngine engine, ArrayDeque<Integer> memoryStack) {
        this.engine = engine;
        this.memoryStack = memoryStack;
    }

    @Override
    public void execute(int operand) {

        if (!memoryStack.isEmpty()) {
            engine.pushOperand(memoryStack.pop());
        }
    }
}
