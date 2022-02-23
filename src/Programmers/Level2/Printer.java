package Programmers.Level2;

import java.util.Collections;
import java.util.PriorityQueue;


public class Printer {
    public int solution(int[] priorities, int location) {
        // 몇 번째로 끝나는지 알려주는 값. 1부터 시작
        int answer = 1;

        // 우선순위 큐 사용.
        // Collections.reverseOrder()를 사용하면 값이 높은 것부터 꺼낸다. (내림차순)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int pri : priorities) {
            pq.add(pri);
        }


        while(!pq.isEmpty()) {
            for(int i=0; i< priorities.length; i++) {
                // 꺼낸 값과 priorities에 있는 값과 같은지 확인
                if(pq.peek() == priorities[i]) {
                    // 만약 값이 같으면서 탐색중인 위치가 주어진 위치라면 반환.
                    if(i==location)
                        return answer;
                    // 같은 값이라면 answer 값을 증가시키고,
                    // -> 즉, 이 의미는 priorities가 몇 번째로 나왔는지 체크해주는 값이라고 생각해도 무관하다.
                    // 만약, 두 번째 예제에서 [1, 1, 9, 1, 1, 1]가 있다고 가정했을 때 우선순위 큐는 [9, 1, 1, 1, 1, 1]이 되는데
                    // 여기서 가장 먼저 꺼낸 9에 대해 생각했을 때, i=2일 때 첫 번째 if문에 의해 조건에 들어오게 되는데,
                    // 우리가 문제에서 원하는 location이 아니기 때문에 answer값을 1 더해주면서 이 친구가 가장 먼저 나왔음을 의미하고,
                    // 그 다음으로 나오는 친구가 answer번째로 나왔음을 의미하게 해주는 것이다! (즉, 그 다음 거는 2번째로 나오게 되는 것)
                    // 큐에서 값을 빼서 더 탐색을 진행한다.
                    answer++;
                    pq.poll();
                }
            }

        }

        return answer;
    }
}
