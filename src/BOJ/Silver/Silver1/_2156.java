package BOJ.Silver.Silver1;

import java.io.*;
import java.util.*;

// 포도주 시식
public class _2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        int[] val = new int[10001];
        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(buf.readLine());
        }

        int[] dp = new int[10001];
        dp[0] = val[0];
        dp[1] = dp[0] + val[1];
        dp[2] = Math.max(dp[1], Math.max(dp[0] + val[2], val[1] + val[2]));

        for (int i = 3; i <= 10000; i++) {
            // 연속으로 3잔을 마실 수가 없다.
            // i-1번째 잔을 마시지 않은 경우 = i-2잔을 고를 수 있음.
            // i-1번째 잔을 마신경우 -> i-2잔을 고를 수가 없으니까 i-3잔을 고르기
            dp[i] = Math.max(dp[i-2] + val[i], dp[i-3] + val[i-1] + val[i]);

            // 마지막 값이 항상 최댓값을 보장하지 않기 때문에,
            // 이전의 누적합과 비교해서 최댓값을 보장해줘야 한다.
            dp[i] = Math.max(dp[i-1], dp[i]);
        }

        buf2.write(Arrays.stream(dp).max().orElse(0) + "");
        buf2.flush();
        buf.close();
        buf2.close();

    }
}
