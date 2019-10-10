package Expressions;

import program.Context;

public class NumberExpression implements IExpression {
    private double numberConstant;

    public NumberExpression(double numberConstant) {
        this.numberConstant = numberConstant;
    }

    @Override
    public Double interpret(Context context) {
        return numberConstant;
    }
}
