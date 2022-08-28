package BOJ.Silver.Silver1;

import java.io.*;
import java.util.StringTokenizer;

// 오르막수
public class _11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        int[][] dp = new int[1001][10];
        int[] ans = new int[1001];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
            ans[0] += ((dp[1][i]) % 10007);
        }


        for (int i = 1; i <= 1000; i++) {
            int answer = 0;
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i-1][k] % 10007;
                    answer += dp[i][j] % 10007;
                }
            }
            ans[i] = answer % 10007;
        }

        buf2.write(ans[n-1] + "");
        buf2.flush();
        buf.close();
        buf2.close();

    }
}
