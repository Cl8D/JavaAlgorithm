package Inflearn.dfs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 6. 순열 구하기
public class _0806 {

    static int[] val, temp;
    static boolean[] visited;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(buf.readLine());

        val = new int[n];
        temp = new int[m];
        visited = new boolean[n];

        for(int i=0; i<n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }

        dfs(0);

    }

    static void dfs(int l) {
        if(l == m) {
            for(int t: temp) {
                System.out.print(t + " ");
            }
            System.out.println();
        }else {
            for(int i=0; i<n; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    temp[l] = val[i];
                    dfs(l + 1);
                    visited[i] = false;
                }
            }

        }

    }
}