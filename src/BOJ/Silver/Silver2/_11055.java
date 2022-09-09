package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 가장 큰 증가 부분 수열
public class _11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        int n = Integer.parseInt(buf.readLine());
        int[] val = new int[n];
        int[] dp = new int[n];

        stk = new StringTokenizer(buf.readLine());
        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }

        dp[0] = val[0];
        int answer = dp[0]; // 초기값 설정 주의

        for (int i = 1; i < n; i++) {
            dp[i] = val[i];
            for (int j = 0; j < i; j++) {
                if(val[i] > val[j]) {
                    // dp[j] : 이전까지의 최대합 + 현재값!
                    dp[i] = Math.max(dp[j] + val[i], dp[i]);
                }
            }
            answer = Math.max(answer, dp[i]);
        }

        buf2.write(answer+"");
        buf2.flush();
        buf.close();
        buf2.close();
    }
}