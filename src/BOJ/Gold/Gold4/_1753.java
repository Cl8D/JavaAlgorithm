package BOJ.Gold.Gold4;

import java.io.*;
import java.util.*;

// 최단경로
public class _1753 {

    // 방문하지 않은 노드 중에서 가장 비용이 적은 노드를 선택해야 하기 때문에
    // 우선순위 큐 활용
    static PriorityQueue<Node> pq;

    // 간선 정보 및 가중치 정보 저장
    static List<Node>[] list;

    // 최소 비용 정보 저장
    static int[] dist;

    // 방문 확인
    static boolean[] visited;

    static final int INF = 999999;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        stk = new StringTokenizer(buf.readLine());
        // 정점의 개수
        int v = Integer.parseInt(stk.nextToken());
        // 간선의 개수
        int e = Integer.parseInt(stk.nextToken());
        // 시작 정점의 번호
        int k = Integer.parseInt(buf.readLine());

        list = new ArrayList[v+1];
        // 초기화
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        dist = new int[v+1];
        // 초기값은 INF으로 채우기
        for (int i = 1; i <= v; i++) {
            dist[i] = INF;
        }

        for (int i = 0; i < e; i++) {
            stk = new StringTokenizer(buf.readLine());
            // start -> end, 가중치 w
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());

            list[start].add(new Node(end, w));
        }

        pq = new PriorityQueue<>();
        visited = new boolean[v+1];

        // 출발 노드 넣어두기
        pq.add(new Node(k, 0));
        dist[k] = 0;

        // 다익스트라 알고리즘 진행
        dijkstra();

        for (int i = 1; i <= v; i++) {
            if (dist[i] == INF) {
                sb.append("INF").append("\n");
                continue;
            }
            sb.append(dist[i]).append("\n");
        }

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }

    private static void dijkstra() {
        while(!pq.isEmpty()) {
            // 가장 비용이 적은 노드 선택
            // 이 노드를 거쳐서 특정한 노드로 가는 경우를 고려하기
            Node current = pq.poll();
            int cv = current.val;

            // 방문하지 않은 노드라면
            if(!visited[cv]) {
                visited[cv] = true;

                // 해당 노드와 연결되어 있는 다른 노드들에 대해서
                for(Node node : list[cv]) {
                    // 바로 가는 것과 거쳐서 가는 것 중에 뭐가 더 최소인지 따지기
                    // 기존의 비용과 새로운 비용을 비교해서 갱신해주는 과정.
                    if (dist[node.val] > dist[cv] + node.weight) {
                        dist[node.val] = dist[cv] + node.weight;
                        pq.add(new Node(node.val, dist[node.val]));
                    }
                }
            }
        }
    }

    // 우선순위 큐에 들어가려면 compareTo 메서드가 필요해서 오버라이딩 해줘야 한다.
    static class Node implements Comparable<Node> {
        int val;
        int weight;

        public Node(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}