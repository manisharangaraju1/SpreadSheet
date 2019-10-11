package interpreter;

import program.Context;

/**
 * Class to perform sin operation of expressions like:
 * $C sin
 *
 * Interpreting this returns the sin value of the expression(which is in turn interpreted).
 */

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
