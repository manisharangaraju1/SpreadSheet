package Expressions;

import program.Context;

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
