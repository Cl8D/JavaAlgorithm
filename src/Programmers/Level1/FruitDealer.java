package Programmers.Level1;

import java.util.Arrays;
import java.util.Collections;

// 과일장수
class FruitDealer {
    public int solution(int k, int m, int[] score) {
        int[] sortedScore = Arrays.stream(score).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

        int answer = 0;
        int idx = m - 1;
        int len = score.length;
        while (idx < len) {
            answer += sortedScore[idx] * m;
            idx += m;
        }
        return answer;
    }
}