package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 이항 계수 2
public class _11051 {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        dp = new int[1001][1001];

        buf2.write(recur(n, k) + "");

        buf2.flush();
        buf.close();
        buf2.close();
    }

    static int recur(int n, int k) {
        if(k==0 || k==n) {
            dp[n][k] = 1;
            return 1;
        }
        if(dp[n][k] != 0) {
            return dp[n][k] % 10007;
        }
        return dp[n][k] = (recur(n-1, k-1) + recur(n-1, k)) % 10007;
    }
}
