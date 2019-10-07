package Interpreter;

import java.util.Stack;

public class Main {

	public double evaluate(String expression) {
		Stack<IExpression> stack = new Stack<>();
		String[] tokens = expression.split(" ");

		for (String token: tokens) {
			System.out.println(token);
			IExpression num = null;
			if (isOperator(token)) {
				IExpression right = stack.pop();
				IExpression left = stack.pop();
				IExpression operator = OperatorFactory.getInstance(token, left, right);
				num = new Number(operator.evaluate());
			}else if(token.equals("lg")) {
				IExpression operand = stack.pop();
				IExpression operator = OperatorFactory.getInstance(token, operand);
				num = new Number(operator.evaluate());
			}else if(token.equals("sin")) {
				IExpression operand = stack.pop();
				IExpression operator = OperatorFactory.getInstance(token, operand);
				num = new Number(operator.evaluate());
			}
			else {
				num = new Number(Double.parseDouble(token));
			}
			stack.push(num);
		}
		return stack.peek().evaluate();
	}


	private static boolean isOperator(String token) {
		if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
			return true;
		}
		return false;
	}
}
