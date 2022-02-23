package BOJ.Silver.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(buf.readLine());

        // 다리를 건너는 트럭의 수
        int n = Integer.parseInt(str.nextToken());

        // 다리의 길이
        int w = Integer.parseInt(str.nextToken());

        // 다리의 최대 하중
        int l = Integer.parseInt(str.nextToken());

        // 트럭의 무게
        int[] truck_weights = new int[n];

        StringTokenizer str2 = new StringTokenizer(buf.readLine());
        for (int i=0; i<n; i++) {
            truck_weights[i] = Integer.parseInt(str2.nextToken());
        }

        // 결과
        int result = 0;

        // 큐를 곧 다리라고 생각하자.
        // 큐에는 다리의 길이만큼 트럭이 들어갈 수 있다.
        Queue<Integer> queue = new LinkedList<>();

        // 큐에 들어있는 트럭의 무게를 담는 변수
        int queue_weight = 0;

        for(int truck : truck_weights) {
            while(true) {
                // 1. 만약 큐가 비어있다면
                if(queue.isEmpty()) {
                    // 큐에 트럭을 넣어주기
                    queue.add(truck);
                    queue_weight += truck;
                    // 큐에 트럭이 들어갔다 = 한 칸 전진하였다 = 1초 증가.
                    result++;
                    // while문 종료. 결론적으로 트럭이 다리에 들어가는 게 목적이니까.
                    break;
                }

                // 2. 만약 큐가 가득차있다면 = 최대 길이가 될 수 있는 다리의 길이와 동일하다면
                else if(queue.size() == w) {
                    // 큐에서 트럭을 빼주기.
                    queue_weight -= queue.poll();
                }

                // 3. 만약 큐에 자리가 있고,
                // 현재 탐색하는 트럭의 무게와 현재 큐에 들어있는 트럭의 무게의 합이 최대 하중을 넘지 않는다면
                else if (queue_weight + truck <= l) {
                    // 트럭을 하나 더 넣어준다.
                    queue.add(truck);
                    queue_weight += truck;
                    result++;
                    break;
                }

                // 4. 만약, 자리는 있지만 최대 하중을 넘는다면
                else {
                    // 무게에 영향을 주지 않는 0을 넣어준다.
                    queue.add(0);
                    result++;
                }
            }
        }

        // 위 반복문이 종료되면 큐에 가장 마지막 트럭만 삽입된 상태이기 때문에
        // 마지막 트럭이 이동하는 만큼 추가해준다.
        result += w;

        System.out.println(result);

    }
}
