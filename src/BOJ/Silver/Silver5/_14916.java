package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 거스름돈
public class _14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        // 2원, 5원
        int n = Integer.parseInt(buf.readLine());
        int[] dp = new int[100001];
        dp[1] = dp[3] = -1;
        dp[2] = dp[5] = 1;
        dp[4] = 2;

        for (int i = 6; i <= 100000; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 6; i <= 100000; i++) {
            if (dp[i-2] == -1 && dp[i-5] == -1) {
                dp[i] = -1;
            } else if (dp[i-2] == -1) {
                dp[i] = dp[i-5] + 1;
            } else if (dp[i-5] == -1) {
                dp[i] = dp[i-2] + 1;
            } else {
                dp[i] = Math.min(dp[i - 2] + 1, dp[i - 5] + 1);
            }
        }

        buf2.write(dp[n]+"");
        buf2.flush();
        buf.close();
        buf2.close();
    }
}