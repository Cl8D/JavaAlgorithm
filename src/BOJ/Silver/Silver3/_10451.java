package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 순열 사이클
public class _10451 {
    static boolean[] visited;
    static int[] val;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        int t = Integer.parseInt(buf.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(buf.readLine());
            stk = new StringTokenizer(buf.readLine());
            val = new int[n+1];
            visited = new boolean[n+1];

            for (int j = 1; j <= n; j++) {
                val[j] = Integer.parseInt(stk.nextToken());
            }

            int answer = 0;

            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    // 방문했는지 체크 -> 방문 안 했으면 해당 배열에 존재하는 값 타고 들어가면서 체크해주기
                    recur(j);
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }

    static void recur(int idx) {
        visited[idx] = true;
        if (!visited[val[idx]]) {
            recur(val[idx]);
        }
    }
}