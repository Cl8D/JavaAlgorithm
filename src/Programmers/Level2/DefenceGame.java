package Programmers.Level2;

import java.util.*;

// 디펜스 게임
class DefenceGame {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        // 남은 병사의 수보다 현재 라운드의 적의 수가 많으면 게임 종료
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int soldier = n;

        for (int i=0; i<enemy.length; i++) {
            int en = enemy[i];
            soldier -= en;
            pq.add(en);

            // 만약 군인의 수가 부족하다면
            if (soldier < 0) {
                // 무적권을 쓸 수 있는지 체크. -> 앞선 라운드에 대해 무적권을 써서 현재 라운드를 통과하도록.
                if (k > 0 && !pq.isEmpty()) {
                    // 무적권을 썼기 때문에 병사를 반환한다.
                    soldier += pq.poll();
                    k--;
                } else {
                    // 안 된다면 현재. 
                    answer = i;
                    break;
                }
            }
        }

        // 모든 라운드에서 무적권을 썼을 경우
        if (answer == 0) {
            return enemy.length;
        }

        return answer;
    }
}