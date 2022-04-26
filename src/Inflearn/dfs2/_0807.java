package Inflearn.dfs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 7. 조합의 경우수(메모이제이션)
public class _0807 {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int r = Integer.parseInt(stk.nextToken());

        dp = new int[34][34];

        System.out.println(dfs(n,r));
    }

    static int dfs(int n, int r) {
        if(r==n || r==0) {
            return 1;
        }

        if(dp[n][r] > 0)
            return dp[n][r];

        else
            return dp[n][r] = dfs(n-1, r-1) + dfs(n-1, r);
    }

}