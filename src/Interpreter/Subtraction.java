package Interpreter;

public class Subtraction implements IExpression {

	private final IExpression left;
	private final IExpression right;

	public Subtraction(IExpression left, IExpression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public double evaluate() {
		return left.evaluate() - right.evaluate();
	}
}
