package _09Polymorphism.Calculator;

public class CalculationEngine {

    private int result;

    public int getCurrentResult() {
        return result;
    }

    public void setCurrentResult(int result) {
        this.result = result;
    }

    public void pushOperand(int operand) {
        this.result = operand;
    }
}
