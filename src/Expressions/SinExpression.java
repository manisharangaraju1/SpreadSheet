package Expressions;

import program.Context;

public class SinExpression implements IExpression {
    private IExpression operand;

    public SinExpression(IExpression operand) {
        this.operand = operand;
    }

    @Override
    public Double interpret(Context context) {
        return Math.sin(operand.interpret(context));
    }
}
