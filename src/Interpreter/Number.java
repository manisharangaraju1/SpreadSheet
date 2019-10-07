package Interpreter;

public class Number implements IExpression {

	private final double number;

	public Number(double number) {
		this.number = number;
	}

	@Override
	public double evaluate() {
		return this.number;
	}
}
