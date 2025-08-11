package _09Polymorphism.Calculator;

public class MultiplicationOperation implements Operation {

    private CalculationEngine engine;

    public MultiplicationOperation(CalculationEngine engine) {
        this.engine = engine;
    }

    @Override
    public void execute(int operand) {
        engine.setCurrentResult(engine.getCurrentResult() * operand);
    }
}
