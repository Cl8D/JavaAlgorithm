package Programmers.Level1;

import java.util.*;

// 햄버거 만들기
class MakeHamburger {
    public int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        // 1 -> 빵, 2 -> 야채, 3 -> 고기
        for (int value : ingredient) {
            stack.add(value);

            if (stack.size() >= 4) {
                int size = stack.size();
                if (stack.get(size-1) == 1
                        && stack.get(size-2) == 3
                        && stack.get(size-3) == 2
                        && stack.get(size-4) == 1) {
                    answer++;
                    for (int i=0; i<4; i++) {
                        stack.pop();
                    }
                }
            }
        }
        return answer;
    }
}