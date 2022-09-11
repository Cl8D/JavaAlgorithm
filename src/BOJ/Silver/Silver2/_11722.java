package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 가장 긴 감소하는 부분 수열
public class _11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        int n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());

        int[] val = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (val[i] < val[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        buf2.write(Arrays.stream(dp).max().getAsInt() + "");
        buf2.flush();
        buf.close();
        buf2.close();
    }
}