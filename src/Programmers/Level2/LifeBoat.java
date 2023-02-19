package Programmers.Level2;

import java.util.*;

// 구명보트
class LifeBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int targetIdx = 0;

        // [70, 40, 50, 90, 100, 20]
        // 20 40 50 70 90 100

        // 끝에서부터 처음이랑 매칭시켜주기
        for (int i=people.length-1; i>=targetIdx; i--) {
            answer++;
            if (i == targetIdx) {
                break;
            }
            if (people[i] + people[targetIdx] <= limit) {
                // 앞에서부터 순차적으로 구한 애들을 더 이상 점검하지 않도록 인덱스 이동시키기
                targetIdx++;
            }

        }

        return answer;
    }
}