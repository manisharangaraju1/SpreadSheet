package interpreter;

import program.Context;

/**
 * Class to perform division of expressions like:
 * $C $D /
 *
 * Interpreting this returns the quotient of two expressions(which are inturn interpreted).
 */

public class DivideExpression implements IExpression {
    private IExpression leftOperand;
    private IExpression rightOperand;

    public DivideExpression(IExpression leftOperand, IExpression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    @Override
    public Double interpret(Context context) {
        return leftOperand.interpret(context) / rightOperand.interpret(context)  ;
    }
}
