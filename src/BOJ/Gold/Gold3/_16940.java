package BOJ.Gold.Gold3;

import java.io.*;
import java.util.*;

// BFS 스폐셜 저지
public class _16940 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        int n = Integer.parseInt(buf.readLine());

        List<Integer>[] list = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            stk = new StringTokenizer(buf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        stk = new StringTokenizer(buf.readLine());
        int[] orders = new int[n+1];
        for (int i = 0; i < n; i++) {
            orders[i] = Integer.parseInt(stk.nextToken());
        }

        // 시작 정점이 1이기 때문에, 첫 방문이 1이 아니라면 올바르지 않는다.
        if (orders[0] != 1) {
            System.out.println(0);
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        queue.add(1); // 시작 정점 넣어두기
        visited[1] = true;

        // 현재 방문을 진행할 타겟 (순서 배열의 인덱스)
        int start = 1;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            List<Integer> children = list[current];

            // 현재 노드의 자식 노드의 개수
            int count = 0;
            for (int child : children) {
                if (!visited[child]) {
                    visited[child] = true;
                    count++;
                }
            }

            // 방문해야 하는 자식 노드의 개수만큼, 탐색 순서 배열 확인하기
            for (int i = start; i < start + count; i++) {
                // 현재 방문이 완료되어야 하는 정점.
                int visitNumber = orders[i];

                // 위에서 자식 노드는 모두 방문 처리를 했기 때문에, 만약 방문하지 않았다면 잘못된 순서.
                if (!visited[visitNumber]) {
                    System.out.println(0);
                    return;
                }

                // 방문이 완료되었다면 해당 노드의 자식에 대해서 탐색할 수 있도록 만들기 위해 큐에 넣기
                queue.add(orders[i]);
            }

            // 방문한 만큼 시작점 이동시키기
            start += count;
        }

        System.out.println(1);
        buf2.flush();
        buf.close();
        buf2.close();
    }
}
