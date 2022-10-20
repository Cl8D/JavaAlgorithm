package BOJ.Gold.Gold5;

import java.io.*;
import java.util.*;

// 최소비용 구하기
public class _1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        // 도시의 개수
        int n = Integer.parseInt(buf.readLine());

        // 버스의 개수
        int m = Integer.parseInt(buf.readLine());
        List<Node>[] list = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(buf.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            int cost = Integer.parseInt(stk.nextToken());

            list[start].add(new Node(end, cost));
        }

        stk = new StringTokenizer(buf.readLine());

        // 출발점의 도시 번호
        int start = Integer.parseInt(stk.nextToken());
        // 도착점의 도시번호
        int end = Integer.parseInt(stk.nextToken());

        final int INF = Integer.MAX_VALUE;

        int[] dist = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dist[i] = INF;
        }

        boolean[] visited = new boolean[n+1];

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            int v = current.val;
            if(!visited[v]) {
                visited[v] = true;

                for(Node node : list[v]) {
                    if (dist[node.val] > dist[v] + node.cost) {
                        dist[node.val] = dist[v] + node.cost;
                        queue.add(new Node(node.val, dist[node.val]));
                    }
                }
            }
        }

        buf2.write(dist[end] + "");
        buf2.flush();
        buf.close();
        buf2.close();
    }

    static class Node implements Comparable<Node> {
        int val;
        int cost;

        public Node(int val, int cost) {
            this.val = val;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

}