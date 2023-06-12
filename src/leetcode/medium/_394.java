package leetcode.medium;


import java.util.Stack;

// 394. Decode String
class _394 {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> numbers = new Stack<>();

        String[] strs = s.split("");
        StringBuilder answer = new StringBuilder("");

        StringBuilder numberGenerator = new StringBuilder("");
        boolean isNumber = false;
        for (String str : strs) {
            if (Character.isDigit(str.charAt(0))) {
                numberGenerator.append(str);
                isNumber = true;
                continue;
            }

            if (isNumber) {
                numbers.add(Integer.parseInt(numberGenerator.toString()));
                numberGenerator = new StringBuilder("");
                isNumber = false;
            }

            if (str.equals("]")) {
                StringBuilder target = new StringBuilder("");
                while (!stack.peek().equals("[")) {
                    target.append(stack.pop());
                }
                Integer number = numbers.pop();
                stack.pop(); // [ 제거
                stack.add(target.toString().repeat(number));
                continue;
            }

            stack.add(str);
        }

        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }

        return answer.reverse().toString();
    }
}
