package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 외판원 순회 2
public class _10971 {
    static int[][] val;
    static int n, answer = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        n = Integer.parseInt(buf.readLine());

        // 도시 i에서 도시 j로 가기 위한 비용
        // 비용은 대칭적이지 않으며, 0 이상의 값.
        // 한 번 갔던 곳을 다시 못 가지만, 순회를 위해 초기로 돌아오는 건 가능.
        val = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(buf.readLine());
            for (int j = 0; j < n; j++) {
                val[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        // 각 행의 첫 번째 도시부터 방문 진행하기
        for (int i = 0; i < n; i++) {
            // 처음 시작 도시에 대해서 방문 처리 (시작)
            visited[i] = true;
            dfs(i, i, 0, 0);
        }

        buf2.write(answer+"");

        buf2.flush();
        buf.close();
        buf2.close();
    }

    // 시작점, 현재 도시 위치, level, 비용
    static void dfs(int start, int now, int level, int cost) {
        // 처음 시작 도시를 다시 돌아가야 하니까...
        // 마지막 경로면 level이 n-1이 되었으면서 시작 경로일 때.
        if (level == n-1) {
            // 0이면 갈 수 없으니까 0이 아닐 경우에 대해서
            if (val[now][start] != 0) {
                cost += val[now][start];
                answer = Math.min(answer, cost);
            }
            return;
        }

        // 방문 시작
        // nxn의 맵이기 때문에 now를 행으로, 반복문으로 열 돌면서 전부 다 탐색 진행하기
        for (int i = 0; i < n; i++) {
            // 갈 수 있으면서 아직 방문하지 않았을 경우
            if (val[now][i] != 0 && !visited[i]) {
                // 백트래킹
                visited[i] = true;
                dfs(start, i, level+1, cost+val[now][i]);
                visited[i] = false;
            }
        }


    }
}