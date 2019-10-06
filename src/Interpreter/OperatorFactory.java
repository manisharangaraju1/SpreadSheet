package Interpreter;

public class OperatorFactory {

	public static IExpression getInstance(String operator, IExpression operand1, IExpression operand2) {
		switch (operator) {
			case "+":
				return new Addition(operand1, operand2);
			case "-":
				return new Subtraction(operand1, operand2);
			case "*":
				return new Multiplication(operand1, operand2);
			case "/":
				return new Division(operand1, operand2);
		}
		return null;
	}

}
