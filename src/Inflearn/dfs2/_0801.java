package Inflearn.dfs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1. 합이 같은 부분집합 (DFS : 아마존 인터뷰)
public class _0801 {
    static int[] val;
    static boolean[] visited;
    static int n, sum, temp;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());

        val = new int[n];
        visited = new boolean[n];

        for(int i=0; i<n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }

        sum = Arrays.stream(val).sum();

        dfs(0);

        if(result == 1)
            System.out.println("YES");
        else
            System.out.println("NO");

    }

    static void dfs(int v){
        if(v==n) {
            for(int i=0; i<visited.length; i++) {
                if(visited[i])
                    temp += val[i];
            }
            if(temp == (sum-temp) && result == -1)
                result = 1;
            temp = 0;
        }
        else {
            visited[v] = true;
            dfs(v + 1);
            visited[v] = false;
            dfs(v + 1);
        }
    }
}