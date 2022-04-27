package Inflearn.dfs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 9. 조합 구하기
public class _0809 {
    static boolean[] visited;
    static int[] temp;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        temp = new int[m];
        visited = new boolean[n+1];

        dfs(0, 1);
    }

    static void dfs(int level, int start) {
        if(level==m) {
            for(int t : temp)
                System.out.print(t + " ");
            System.out.println();
        }
        else {
            for(int i=start; i<=n; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    temp[level] = i;
                    dfs(level+1, i+1);
                    visited[i] = false;
                }
            }
        }
    }
}