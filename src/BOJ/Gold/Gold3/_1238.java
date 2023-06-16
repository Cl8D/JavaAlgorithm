package BOJ.Gold.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 파티 - 다익스트라 응용 문제
public class _1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());

        // 학생의 수
        int n = Integer.parseInt(stk.nextToken());
        // 도로의 수
        int m = Integer.parseInt(stk.nextToken());
        // 모일 마을 (도착지)
        int x = Integer.parseInt(stk.nextToken());

        List<Node>[] forwardRoads = new ArrayList[n + 1];
        List<Node>[] backwardRoads = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            forwardRoads[i] = new ArrayList<>();
            backwardRoads[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(buf.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            int time = Integer.parseInt(stk.nextToken());

            // 단방향이니까 각각에 대해 선언하기
            forwardRoads[start].add(new Node(end, time));
            backwardRoads[end].add(new Node(start, time));
        }

        int[] forwardDist = new int[n+1];
        int[] backwardDist = new int[n+1];

        for (int i = 0; i <= n; i++) {
            forwardDist[i] = Integer.MAX_VALUE;
            backwardDist[i] = Integer.MAX_VALUE;
        }

        // 가는 거
        dijkstra(forwardDist, forwardRoads, x);

        // 다시 돌아오는 거
        dijkstra(backwardDist, backwardRoads, x);

        int answer = 0;
        for (int i = 0; i < forwardDist.length; i++) {
            if (forwardDist[i] != Integer.MAX_VALUE && backwardDist[i] != Integer.MAX_VALUE) {
                final int sum = forwardDist[i] + backwardDist[i];
                answer = Math.max(answer, sum);
            }
        }

        System.out.println(answer);
        buf.close();
    }

    private static void dijkstra(final int[] dist, final List<Node>[] roads, final int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(x, 0));
        dist[x] = 0;

        while (!pq.isEmpty()) {
            final Node current = pq.poll();
            int target = current.target;
            int time = current.time;

            // 이미 처리가 완료됨
            if (dist[target] < time) {
                continue;
            }

            for (Node node : roads[target]) {
                if (dist[node.target] > dist[target] + node.time) {
                    dist[node.target] = dist[target] + node.time;
                    pq.add(new Node(node.target, dist[node.target]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int target;
        int time;

        public Node(final int target, final int time) {
            this.target = target;
            this.time = time;
        }

        @Override
        public int compareTo(final Node o) {
            // 내림차순으로 정렬
            return o.time - time;
        }
    }
}
