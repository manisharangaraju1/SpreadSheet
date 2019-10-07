package Interpreter;

public class Sin implements IExpression {
    private final IExpression operand;


    public Sin(IExpression operand) {
        this.operand = operand;
    }

    @Override
    public double evaluate() {
        return Math.sin(operand.evaluate());
    }
}
