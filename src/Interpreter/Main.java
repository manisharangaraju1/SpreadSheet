package Interpreter;

import java.util.Stack;

public class Main {

	public int evaluate(String expression) {
		Stack<IExpression> stack = new Stack<>();
		String[] tokens = expression.split(" ");
		for (String token: tokens) {
			IExpression num = null;
			if (isOperator(token)) {
				IExpression right = stack.pop();
				IExpression left = stack.pop();
				IExpression operator = OperatorFactory.getInstance(token, left, right);
				num = new Number(operator.evaluate());
			} else {
				num = new Number(Integer.parseInt(token));
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
