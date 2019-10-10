package Expressions;

import program.Context;

public class MultiplyExpression implements IExpression {
    private IExpression leftOperand;
    private IExpression rightOperand;

    public MultiplyExpression(IExpression leftOperand, IExpression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    @Override
    public Double interpret(Context context) {
        return rightOperand.interpret(context) * leftOperand.interpret(context);
    }
}
