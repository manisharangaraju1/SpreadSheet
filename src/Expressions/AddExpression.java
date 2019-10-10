package Expressions;

import program.Context;

public class AddExpression implements IExpression {

    private IExpression leftOperand;
    private IExpression rightOperand;

    public AddExpression(IExpression leftOperand, IExpression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    @Override
    public Double interpret(Context context) {
        return leftOperand.interpret(context) + rightOperand.interpret(context);
    }
}
