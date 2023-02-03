package Programmers.Level2;

import java.util.*;

// 뒤에 있는 큰 수 찾기
class FindBehindBigValue {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Number> stack = new Stack<>();

        for (int i=0; i<numbers.length; i++) {
            int number = numbers[i];

            while (!stack.isEmpty() && stack.peek().value < number) {
                answer[stack.peek().idx] = number;
                stack.pop();
            }
            stack.push(new Number(i, number));
        }

        return answer;
    }

    private static class Number {
        int idx;
        int value;

        public Number(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}