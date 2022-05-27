package BOJ.Silver.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연결 요소의 개수
public class _11724 {
    static int[][] val;
    static boolean[] visited;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());
        // 정점의 개수
        n = Integer.parseInt(stk.nextToken());
        // 간선의 개수
        m = Integer.parseInt(stk.nextToken());

        val = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=0; i<m; i++) {
            stk = new StringTokenizer(buf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            // 연결된 정점 = 1
            val[a][b] = val[b][a] = 1;
        }

        int count = 0;
        for(int i=1; i<=n; i++) {
            // 각 정점의 방문여부 체크
            // 하나의 정점에 대해 모두 탐색이 끝났으면 count+1 (시작점부터 방문 확인)
            // 연결되어 있으면 dfs 내에서 방문처리가 되었기 때문에 방문이 되지 않은 것들에 대해서만 새롭게 count+1이 된다.
            if(!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);

    }

    static void dfs(int start) {
        visited[start] = true;

        for(int i=1; i<=n; i++) {
            // 방문이 되지 않았으면서, 둘이 연결되어 있다면
            if(!visited[i] && val[start][i] == 1)
                // 해당 요소를 시작점으로 하여 다시 방문 탐색 시작!
                dfs(i);
        }
    }
}