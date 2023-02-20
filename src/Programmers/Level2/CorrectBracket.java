package Programmers.Level2;

import java.util.*;

// 올바른 괄호
class CorrectBracket {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.charAt(0) == ')') {
            return false;
        }
        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }
        }


        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }
}