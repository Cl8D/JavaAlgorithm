
import java.io.*;
import java.util.*;

public class Main {
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