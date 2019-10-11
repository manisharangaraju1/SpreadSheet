package interpreter;

import program.Context;

/**
 * Expression to represent variables in expressions like:
 * $D
 * The expression contains the variable name.
 * Interpreting this returns the value of the variable.
 */

public class VariableExpression implements IExpression {

    private String name;

    public VariableExpression(String name) {
        this.name = name;
    }

    @Override
    public Double interpret(Context context) {
        return context.getVariableValue(name);
    }

}
