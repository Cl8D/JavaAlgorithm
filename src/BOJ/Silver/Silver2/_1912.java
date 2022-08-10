package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 연속합
public class _1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }
        int[] dp = new int[n];
        dp[0] = val[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(val[i], dp[i-1] + val[i]);
        }
        buf2.write(Arrays.stream(dp).max().orElse(0)+"");
        buf2.flush();
        buf.close();
        buf2.close();

    }
}
