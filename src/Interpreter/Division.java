package Interpreter;

public class Division implements IExpression {

	private final IExpression left;
	private final IExpression right;

	public Division(IExpression left, IExpression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public int evaluate() {
		return left.evaluate() / right.evaluate();
	}
}
