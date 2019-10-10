package program;

import Expressions.*;

import java.util.Stack;

public class Parse {

    public static Double parse(String inputExpression, Context context) {
        Stack<IExpression> stack = new Stack<>();
        String[] tokens = inputExpression.split(" ");

        for (String token: tokens) {
            ConstantExpression num = null;
            if (isOperator(token)) {
                IExpression right = stack.pop();
                IExpression left = stack.pop();
                IExpression operator = getInstance(token, left, right);
                num = new ConstantExpression(operator.interpret(context));
            }else if(token.equals("lg") || token.equals("sin")) {
                IExpression operand = stack.pop();
                IExpression operator = getInstance(token, operand);
                num = new ConstantExpression(operator.interpret(context));
            }else if(token.charAt(0) == '$') {
                VariableExpression variableExpression = new VariableExpression(token);
               num = new ConstantExpression(variableExpression.interpret(context));
            } else {
                num = new ConstantExpression(Double.parseDouble(token));
            }
            stack.push(num);
        }
        return stack.peek().interpret(context);
    }

    private static boolean isOperator(String token) {
        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
            return true;
        }
        return false;
    }

    public static IExpression getInstance(String operator, IExpression operand1, IExpression operand2) {
        switch (operator) {
            case "+":
                return new AddExpression(operand1, operand2);
            case "-":
                return new SubtractExpression(operand1, operand2);
            case "*":
                return new MultiplyExpression(operand1, operand2);
            case "/":
                return new DivideExpression(operand1, operand2);
        }
        return null;
    }

    public static IExpression getInstance(String operator, IExpression operand) {
        switch (operator) {
            case "sin":
                return new SinExpression(operand);
            case "lg":
                return new LogExpression(operand);
        }
        return null;
    }

}


