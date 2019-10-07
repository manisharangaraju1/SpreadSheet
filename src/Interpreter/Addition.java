package Interpreter;

public class Addition implements IExpression {

	private final IExpression left;
	private final IExpression right;

	public Addition(IExpression left, IExpression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public double evaluate() {
		return left.evaluate() + right.evaluate();
	}
}
