package _09Polymorphism.Calculator;

public class DivisionOperation implements Operation {

    private CalculationEngine engine;

    public DivisionOperation(CalculationEngine engine) {
        this.engine = engine;
    }

    @Override
    public void execute(int operand) {
        engine.setCurrentResult(engine.getCurrentResult() / operand);
    }
}
