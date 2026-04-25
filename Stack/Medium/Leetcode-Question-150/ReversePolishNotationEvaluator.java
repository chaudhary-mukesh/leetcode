import java.util.Stack;

public class ReversePolishNotationEvaluator {

    public int evaluateExpression(String[] tokens) {

        // Stack to store operands (numbers)
        Stack<Integer> operandStack = new Stack<>();

        // Traverse each token in the input
        for (String currentToken : tokens) {

            // If the token is an operator, perform calculation
            if (isOperator(currentToken)) {

                // Pop the top two elements from the stack
                // Note: Order matters (a operator b)
                int secondOperand = operandStack.pop();
                int firstOperand = operandStack.pop();

                // Perform the operation
                int result = performOperation(currentToken, firstOperand, secondOperand);

                // Push the result back to the stack
                operandStack.push(result);

            } else {
                // If the token is a number, parse and push to stack
                operandStack.push(Integer.parseInt(currentToken));
            }
        }

        // Final result will be the only element left in the stack
        return operandStack.pop();
    }

    // Helper method to check if a token is an operator
    private boolean isOperator(String token) {
        return token.equals("+") ||
               token.equals("-") ||
               token.equals("*") ||
               token.equals("/");
    }

    // Helper method to perform arithmetic operations
    private int performOperation(String operator, int a, int b) {

        switch (operator) {
            case "+":
                return a + b;

            case "-":
                return a - b;

            case "*":
                return a * b;

            case "/":
                // Integer division (truncates toward zero)
                return a / b;

            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}