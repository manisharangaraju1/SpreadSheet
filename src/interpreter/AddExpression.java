package interpreter;

import program.Context;

/**
 * Class to perform addition of expressions like:
 * $C $D +
 *
 * Interpreting this returns the sum of two expressions(which are inturn interpreted).
 */

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
