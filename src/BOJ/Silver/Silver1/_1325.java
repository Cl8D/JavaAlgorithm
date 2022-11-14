package BOJ.Silver.Silver1;

import java.io.*;
import java.util.*;

// 효율적인 해킹
public class _1325 {
    static int n, m;
    static List<Integer>[] val;
    static boolean[] visited;

    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        stk = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        val = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            val[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(buf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            val[a].add(b);
        }

        answer = new int[n+1];

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n+1];
            visited[i] = true;
            dfs(i);
        }

        int max = Arrays.stream(answer).max().getAsInt();

        for (int i = 1; i <= n; i++) {
            if (max == answer[i]) {
                sb.append(i).append(" ");
            }
        }
        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }

    static void dfs(int level) {
        // 그냥 for문으로 돌면 시간 초과 난다. for-each문으로 돌아야 함!
        for (int current : val[level]) {
            if (!visited[current]) {
                visited[current] = true;
                answer[current]++;
                dfs(current);
            }
        }
    }
}