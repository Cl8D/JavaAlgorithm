package Programmers.Level2;

import java.util.*;

// 더 맵게 - 리팩토링 코드 (더 효율적이다)
class MoreSpicy2 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int sc : scoville) {
            pq.add(sc);
        }

        while (pq.size() > 1 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            pq.add(first + second * 2);
            answer++;
        }

        if (pq.size() == 1 && pq.peek() < K) {
            return -1;
        }

        return answer;
    }

}

// 더 맵게 - 첫 번째 풀이
class MoreSpicy {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int sc : scoville) {
            pq.add(sc);
        }

        while (pq.size() > 1) {
            if (validateScoville(pq, K)) {
                break;
            }
            int first = pq.poll();
            int second = pq.poll();
            pq.add(first + second * 2);
            answer++;
        }

        if (pq.size() == 1 && pq.peek() < K) {
            return -1;
        }

        return answer;
    }

    private boolean validateScoville(PriorityQueue<Integer> pq, int k) {
        int count = 0;
        while (count != pq.size()) {
            int target = pq.poll();
            if (target < k) {
                pq.add(target);
                return false;
            }
            pq.add(target);
            count++;
        }
        return true;
    }
}