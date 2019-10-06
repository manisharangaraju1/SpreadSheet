package Interpreter;

public class Multiplication implements IExpression {

	private final IExpression left;
	private final IExpression right;

	public Multiplication(IExpression left, IExpression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public int evaluate() {
		return left.evaluate() * right.evaluate();
	}
}
