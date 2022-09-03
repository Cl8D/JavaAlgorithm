package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 제곱수의 합
public class _1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        /**
         *  1 -> 1
         *  2- > 1 1
         *  3 -> 1 1 1
         *  4 -> 2 // 1 1 1 1
         *  5 -> 2 1 //
         *  6 -> 2 1 1
         *  7 -> 2 1 1 1
         *  8 -> 2 2 // 2 1 1 1 1
         *  9 -> 3 // 2 2 1
         * 10 -> 3 1 // 2 2 1 1
         * 11 -> 3 1 1 // 2 2 1 1 1
         * 12 -> 3 1 1 1
         * 13 -> 3 2 // 3 1 1 1 1
         * 14 -> 3 2 1
         * 15 -> 3 2 1 1
         * 16 -> 4 // 3 2 1 1 1
         * 17 -> 4 1 // 3 2 2
         * 18 -> 4 1 1 // 3 3
         * 19 -> 4 1 1 1 // 3 3 1
         * 20 -> 4 2
         */
        int n = Integer.parseInt(buf.readLine());
        int[] dp = new int[100001];

        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            // dp[13]
            // dp[13-1*1] + 1, dp[13-2*2] + 1, dp[13-3*3] + 1 이렇게 셋 중 하나
            for (int j = 1; j*j<= i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
            }
        }
        buf2.write(dp[n]+"");
        buf2.flush();
        buf.close();
        buf2.close();

    }
}
