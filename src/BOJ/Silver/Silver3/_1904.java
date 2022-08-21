package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 01타일
public class _1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        int[] dp = new int[1000001];
        dp[1] = 1;
        dp[2] = 2;

        // d[i-2]의 경우에서 뒤에 00을 붙이고 d[i-1]의 경우에 앞에 1을 붙인 경우의 합
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 15746;
        }
        buf2.write(dp[n] + "");
        buf2.flush();
        buf.close();
        buf2.close();

    }
}
