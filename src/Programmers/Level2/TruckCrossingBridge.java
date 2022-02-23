package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class TruckCrossingBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        // 큐에 들어갈 수 있는 최대 개수 = bridge_length
        // weight를 넘지 않으면서 트럭이 들어갈 수 있는 최대 개수
        Queue<Integer> queue = new LinkedList<>();

        int queue_weight = 0;

        for (int truck : truck_weights) {
            // 1. 큐가 비어있을 때 -> 무조건 트럭을 넣는다. + 날짜를 증가시킨다.
            // 2. 큐 안에 있는 트럭의 개수가 bridge_length와 동일할 때
            // -> 큐에서 빼준다.
            // 3. 큐가 차있으면서 아직 넣을 수 있을 때
            // 3-1. 큐 안에 있는 트럭의 전체 무게랑 현재 선택된 truck의 합이 weight보다 작으면
            // -> 트럭을 하나 더 넣어준다.
            // 3-2. 만약 weight보다 크면
            // -> 0을 큐에 넣어주고 시간을 증가시킨다.
            // 큐에 넣는 게 -> 한 칸 전진이니까 -> 시간 +1

            while(true) {
                if(queue.isEmpty()) {
                    queue.add(truck);
                    queue_weight += truck;
                    answer++;
                    break;
                }

                else if(queue.size() == bridge_length) {
                    queue_weight -= queue.poll();
                }

                else if(queue_weight + truck <= weight) {
                    queue.add(truck);
                    answer++;
                    queue_weight += truck;
                    break;
                }

                else {
                    queue.add(0);
                    answer++;
                }
            }
        }

        // 마지막 트럭이 지날 때.
        // 다리 길이만큼 지나가야 하니까
        answer += bridge_length;

        return answer;
    }
}
