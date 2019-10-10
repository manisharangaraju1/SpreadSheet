package Expressions;

import program.Context;

public class SubtractExpression implements IExpression {

    private IExpression leftOperand;
    private IExpression rightOperand;

    public SubtractExpression(IExpression leftOperand, IExpression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    @Override
    public Double interpret(Context context) {
        return rightOperand.interpret(context) - leftOperand.interpret(context);
    }
}
