package BOJ.Silver.Silver1;

import java.io.*;
import java.util.*;

// 카드 구매하기
public class _11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        int[] dp = new int[10001];
        stk = new StringTokenizer(buf.readLine());
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.parseInt(stk.nextToken());
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <=i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + dp[i-j]);
            }
        }

        buf2.write(Arrays.stream(dp).max().getAsInt()+"");

        buf2.flush();
        buf.close();
        buf2.close();

    }
}
