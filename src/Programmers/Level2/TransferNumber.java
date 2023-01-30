package Programmers.Level2;

import java.util.*;

// 숫자 변환하기
class TransferNumber {
    public int solution(int x, int y, int n) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();
        Set<Integer> next = null;
        set.add(x);

        while(!set.isEmpty()) {
            if (set.contains(y)) {
                return answer;
            }
            next = new HashSet<>();
            for (int value : set) {
                if (value + n <= y) {
                    next.add(value + n);
                }
                if (value * 2 <= y) {
                    next.add(value * 2);
                }
                if (value * 3 <= y) {
                    next.add(value * 3);
                }
            }
            set = next;
            answer++;
        }

        return -1;
    }
}