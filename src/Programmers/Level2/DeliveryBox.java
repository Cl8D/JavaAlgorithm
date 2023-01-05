package Programmers.Level2;

import java.util.*;

// 택배상자
class DeliveryBox {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i=1; i<=order.length; i++) {
            if (order[answer] == i) {
                // answer가 곧 다음으로 탐색할 대상으로 생각하는 게 이해가 쉽다.
                answer++;
            } else {
                // 이런 식으로 바로 push 넣어주고 밑의 조건에서 체크.
                stack.push(i);
            }

            while (!stack.isEmpty() && stack.peek() == order[answer]) {
                answer++;
                stack.pop();
            }
        }

        return answer;
    }

}