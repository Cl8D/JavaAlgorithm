package Programmers.Level2;

import java.util.*;

// 짝지어 제거하기
class PairRemove
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(c);
                continue;
            }
            if (stack.peek() == c) {
                stack.pop();
                continue;
            }
            stack.add(c);
        }


        if (stack.isEmpty()) {
            return 1;
        }
        return 0;
    }
}