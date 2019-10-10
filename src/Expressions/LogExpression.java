package Expressions;

import program.Context;

public class LogExpression implements IExpression {
    private IExpression operand;

    public LogExpression(IExpression operand) {
        this.operand = operand;
    }

    @Override
    public Double interpret(Context context) {
        return Math.log(operand.interpret(context));
    }
}
