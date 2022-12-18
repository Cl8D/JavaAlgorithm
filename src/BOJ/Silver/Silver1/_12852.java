package BOJ.Silver.Silver1;

import java.io.*;
import java.util.*;

// 1로 만들기 2
public class _12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        int n = Integer.parseInt(buf.readLine());
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 0;

        int[] val = new int[n+1];

        for (int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + 1;
            val[i] = i-1;

            if (i % 2 == 0 && dp[i] > dp[i/2] + 1) {
                dp[i] = dp[i/2] + 1;
                val[i] = i/2;
            }
            if (i % 3 == 0 && dp[i] > dp[i/3] + 1) {
                dp[i] = dp[i/3] + 1;
                val[i] = i/3;
            }
        }

        int answer = dp[n];
        sb.append(answer).append("\n");

        while(n > 0) {
            sb.append(n).append(" ");
            n = val[n];
        }

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }
}