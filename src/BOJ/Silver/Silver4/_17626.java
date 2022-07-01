package BOJ.Silver.Silver4;

import java.io.*;
import java.util.StringTokenizer;

// Four Squares
public class _17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());

        int[] dp = new int[50001];

        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            // 최대 4자리 수까지 될 수 있으니까 초기화
            dp[i] = 4;

            // i보다 작은 제곱수에 대한 경우를 체크
            for(int j=1; j*j <=i; j++) {
                // dp[i-j*j] + 1 => 여기서 1이 제곱수에 대한 경우의 수 1,
                // 제곱수를 제외한 나머지에 대한 것이 dp[i-j*j]
                // dp 1~10까지 대충 써보면 규칙이 나온다.
                dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
            }
        }

        System.out.println(dp[n]);

        buf.close();
        buf2.close();
    }
}