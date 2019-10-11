package interpreter;

import program.Context;

/**
 * Class to perform multiplication of expressions like:
 * $C $D *
 *
 * Interpreting this returns the product of two expressions(which are inturn interpreted).
 */

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
