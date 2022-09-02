package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// BABBA
public class _9625 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        // b -> ba, a -> b

        // a
        // b -> 1 || 0 1
        // ba -> 2 || 1 1
        // ba b -> 2 + 1 || 1 2
        // ba b ba -> 2 + 1 + 2 + 1 || 2 3
        // ba b ba ba b ba ->  || 4 6
        // ba b ba ba b ba b ba ba b -> || 6 10

        int k = Integer.parseInt(buf.readLine());
        int[][] dp = new int[46][2];
        dp[1][0] = 0; dp[1][1] = 1;
        dp[2][0] = 1; dp[2][1] = 1;

        for (int i = 3; i <= 45; i++) {
            dp[i][0] = dp[i-2][0] + dp[i-1][0];
            dp[i][1] = dp[i-2][1] + dp[i-1][1];
        }

        buf2.write(dp[k][0] + " " + dp[k][1]);

        buf2.flush();
        buf.close();
        buf2.close();

    }
}
