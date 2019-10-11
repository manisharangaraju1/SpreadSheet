package interpreter;

import program.Context;


/**
 * A class to represent a constant expression.
 * It is considered as a terminal expression
 * Interpreting it returns the value that is present in it.
 */

public class ConstantExpression implements ITerminalExpression {
    private double value;


    public ConstantExpression(double value) {
        this.value = value;
    }


    @Override
    public Double interpret(Context context) {
        return value;
    }
}
