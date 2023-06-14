package leetcode.medium;

import java.util.Stack;

// 150. Evaluate Reverse Polish Notation
class _150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token: tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
                continue;
            }
            int val1 = stack.pop();
            int val2 = stack.pop();
            int result = calculate(token, val2, val1);
            stack.push(result);
        }
        return stack.pop();
    }

    private int calculate(String operator, int val1, int val2) {
        if (operator.equals("*")) {
            return val1 * val2;
        }
        if (operator.equals("/")) {
            return val1 / val2;
        }
        if (operator.equals("+")) {
            return val1 + val2;
        }
        return val1 - val2;
    }

    private boolean isNumber(String token) {
        return !token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/");
    }
}


