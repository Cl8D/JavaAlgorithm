package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 이친수
public class _2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        // 수가 엄청 많아서 long형으로 해야 됨...
        long[][] dp = new long[91][2];
        // 각 이진수가 0으로 끝나는 것의 개수랑 1로 끝나는 것의 개수로 나눠준다
        dp[1][0] = 0; dp[1][1] = 1;
        dp[2][0] = 1; dp[2][1] = 0;

        for (int i = 3; i <= n; i++) {
            // 이친수의 규칙을 보면 0으로 끝나는 경우는 해당 수에 0, 1을 붙여서 늘릴 수 있고
            // 1로 끝나는 경우는 11이 들어가면 안 되기 때문에 끝에 0만 붙일 수 있어서
            // dp[i][0]은 이전 것의 0, 1을 더한 경우 dp[i][1]은 0만 붙인 경우로 갱신해나갔다!
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        buf2.write(dp[n][0] + dp[n][1] + "");
        buf2.flush();
        buf.close();
        buf2.close();

    }
}
