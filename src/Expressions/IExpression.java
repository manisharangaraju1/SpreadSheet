package Expressions;

import program.Context;

/*
 * Interface to represent nodes of an expression tree.
 */
public interface IExpression {
    Double interpret(Context context);
}
