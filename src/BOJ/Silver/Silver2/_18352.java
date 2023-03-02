package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

// 특정 거리의 도시 찾기
public class _18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        stk = new StringTokenizer(buf.readLine());

        // 도시의 개수
        int n = Integer.parseInt(stk.nextToken());

        // 도로의 개수
        int m = Integer.parseInt(stk.nextToken());

        // 거리 정보
        int k = Integer.parseInt(stk.nextToken());

        // 출발 도시의 번호
        int x = Integer.parseInt(stk.nextToken());

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(buf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            // 단방향
            graph[a].add(b);
        }

        // 최단 거리 저장
        int[] dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // 생각해보니깐 거리가 다 동일해서 그냥 큐 사용해도 될 듯...?
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        dist[x] = 0;
        pq.add(x);

        List<Integer> answers = new ArrayList<>();
        while (!pq.isEmpty()) {
            Integer current = pq.poll();

            for (Integer child : graph[current]) {
                // 방문하지 않았을 경우, 최단 거리 갱신
                if (dist[child] > dist[current] + 1) {
                    dist[child] = dist[current] + 1;
                    pq.add(child);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dist[i] == k) {
                answers.add(i);
            }
        }

        if (answers.size() == 0) {
            System.out.println(-1);
            return;
        }

        Collections.sort(answers);

        String answer = answers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("\n"));

        System.out.println(answer.trim());
        buf2.flush();
        buf.close();
        buf2.close();
    }
}
