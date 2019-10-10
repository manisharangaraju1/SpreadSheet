package Expressions;

import program.Context;

public class VariableExpression implements IExpression {

    private String name;

    public VariableExpression(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Double interpret(Context context) {
        return context.getVariableValue(name);
    }
}
