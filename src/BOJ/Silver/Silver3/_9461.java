package BOJ.Silver.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 파도반 수열
public class _9461 {
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int t = Integer.parseInt(buf.readLine());

        // int형으로 하면 범위 초과함! long으로 해야 한다
        dp = new long[101];

        dp[1] = dp[2] = dp[3] = 1;
        for(int i=4; i<=100; i++)
            dynamic(i);

        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(buf.readLine());
            System.out.println(dp[n]);
        }

    }

    static long dynamic(int n) {
        return dp[n] = dp[n-3] + dp[n-2];
    }


}