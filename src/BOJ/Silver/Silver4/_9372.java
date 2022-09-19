package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 상근이의 여행
public class _9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        int t = Integer.parseInt(buf.readLine());
        for (int i = 0; i < t; i++) {
            stk = new StringTokenizer(buf.readLine());
            // 국가의 수
            int n = Integer.parseInt(stk.nextToken());
            // 비행기의 종류
            int m = Integer.parseInt(stk.nextToken());

            int[][] val = new int[n+1][n+1];
            boolean[] visited = new boolean[n+1];

            for (int j = 0; j < m; j++) {
                stk = new StringTokenizer(buf.readLine());
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());
                val[a][b] = val[b][a] = 1;
            }

            /*
              1 2 3
            1   * *
            2 *   *
            3 * *

           <queue>
           add 1
           add 2
           add 3

           current = 1
           val[1][2] = 1, visited[2] = false
           answer = 1
           visited[2] = true;

           current = 2 - 2로부터 연결된 점 (1->2)
           val[2][2] = 0
           val[2][3] = 1, visited[3] = false
           answer = 2
           visited[3] = true

           current = 3 - (1->2->3)
           val[3][2] = 0
           visited[3][2] = 1, visited[3] = true
           val[3][3] = 0

           - so, answer is 2
             */

            // 가장 적은 종류의 비행기 타기, bfs
            Queue<Integer> queue = new LinkedList<>();
            queue.add(1);
            visited[1] = true;

            int answer = 0;
            while(!queue.isEmpty()) {
                Integer current = queue.poll();
                for (int j = 2; j <= n; j++) {
                    if(val[current][j]==1 && !visited[j]) {
                        answer++;
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }
            sb.append(answer).append("\n");
        }

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }

}