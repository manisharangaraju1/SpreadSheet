package interpreter;

import program.Context;

/**
 * Class to perform log operation of expressions like:
 * $C lg
 *
 * Interpreting this returns the log (base2) of the expression(which is in turn interpreted).
 */

public class LogExpression implements IExpression {
    private IExpression operand;

    public LogExpression(IExpression operand) {
        this.operand = operand;
    }

    @Override
    public Double interpret(Context context) {
        return Math.log(operand.interpret(context)) / Math.log(2);
    }
}
