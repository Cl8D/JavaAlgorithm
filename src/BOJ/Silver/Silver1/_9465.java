package BOJ.Silver.Silver1;

import java.io.*;
import java.util.*;

// 스티커
public class _9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int t = Integer.parseInt(buf.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(buf.readLine());
            int[][] val = new int[2][n+1];
            for (int j = 0; j < 2; j++) {
                stk = new StringTokenizer(buf.readLine());
                // 밑에서 구현을 쉽게 하기 위해 인덱스를 1부터.
                for (int k = 1; k <= n; k++) {
                    val[j][k] = Integer.parseInt(stk.nextToken());
                }
            }
            int[][] dp = new int[2][n+1];
            dp[0][1] = val[0][1];
            dp[1][1] = val[1][1];

            for(int j=2; j<=n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + val[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + val[1][j];
            }
            buf2.write(Math.max(dp[0][n], dp[1][n]) +"\n");
        }
        buf2.flush();
        buf.close();
        buf2.close();

    }
}
