package Interpreter;

public class Number implements IExpression {

	private final int number;

	public Number(int number) {
		this.number = number;
	}

	@Override
	public int evaluate() {
		return this.number;
	}
}
