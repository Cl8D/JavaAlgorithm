package Inflearn.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10. 경로 탐색(dfs)
public class _0710 {
    static int[][] graph;
    static boolean[] visited;
    static int n;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        graph = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=0; i<m; i++) {
            stk = new StringTokenizer(buf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            graph[a][b] = 1;
        }
        visited[1] = true;
        dfs(1);
        System.out.println(answer);
    }

    static void dfs(int v) {
        if(v==n) {
            answer++;
        }
        else {
            for(int i=1; i<=n; i++) {
                if(graph[v][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    dfs(i);
                    visited[i] = false;
                }
            }
        }
    }
}

