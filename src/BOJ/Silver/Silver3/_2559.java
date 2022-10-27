package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 수열
public class _2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        stk = new StringTokenizer(buf.readLine());
        // 온도를 측정한 날짜의 수
        int n = Integer.parseInt(stk.nextToken());
        // 합을 구하기 위한 연속적인 날짜의 수
        int k = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(buf.readLine());

        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }

        int start = 0, end = start + k - 1;
        int answer = Integer.MIN_VALUE;

        int[] dp = new int[n];
        dp[0] = val[0];

        // 누적합을 먼저 구해두기
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1] + val[i];
        }

        while (end < n) {
            int sum;
            if (start == 0)
                sum = dp[end];
            else
                sum = dp[end] - dp[start-1];

            answer = Math.max(answer, sum);
            start++;;
            end = start + k - 1;
        }

        buf2.write(answer + "");

        buf2.flush();;
        buf.close();
        buf2.close();
    }
}