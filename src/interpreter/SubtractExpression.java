package interpreter;

import program.Context;

/**
 * Class to perform subtraction of expressions like:
 * $C $D -
 *
 * Interpreting this returns the difference of two expressions(which are inturn interpreted).
 */

public class SubtractExpression implements IExpression {

    private IExpression leftOperand;
    private IExpression rightOperand;

    public SubtractExpression(IExpression leftOperand, IExpression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    @Override
    public Double interpret(Context context) {
        return  leftOperand.interpret(context) - rightOperand.interpret(context);
    }
}
