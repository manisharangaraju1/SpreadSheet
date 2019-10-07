package Interpreter;

public class Log implements IExpression {
    private final IExpression operand;

    public Log(IExpression operand) {
        this.operand = operand;
    }

    @Override
    public double evaluate() {
        return Math.log(operand.evaluate());
    }
}
