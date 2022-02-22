package Level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FunctionDevelopment {
    // progress -> 배포되어야 하는 순서대로 적힌 작업의 진도
    // 이전의 기능이 배포되어야만 배포 가능
    // speeds -> 작업의 개발 속도
    public int[] solution(int[] progresses, int[] speeds) {
        // 몇 개의 기능이 배포되는지
        int[] answer = {};
        int idx = 0;

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<progresses.length; i++) {
            int cnt = progresses[i];
            int days = 0;
            while(true) {
                if (cnt>=100)
                    break;
                cnt += speeds[i];
                days++;
            }
            queue.add(days);
        }

        List<Integer> list = new ArrayList<>();

        while(!queue.isEmpty()) {
            // 첫 번째 작업물이 걸리는 날짜
            int first = queue.poll();

            // 배포 가능 개수.
            int cnt = 1;

            // 첫 번째 이후 작업물이 걸리는 날짜와 비교
            while(!queue.isEmpty() && first >= queue.peek()) {
                // 첫 번째 작업물이 시간이 더 걸린다면,
                // 두 번째 작업물은 첫 번째 작업이 완료되기 전에 다 끝나는 상태
                // 그 다음 작업물이 첫 번째 작업이 되는 동안 가능한지 탐색
                cnt++;
                queue.poll();
            }

            idx++;
            list.add(cnt);
        }


        answer = new int[idx];

        for(int i =0; i<idx; i++)
            answer[i] = list.get(i);

        return answer;
    }
}
