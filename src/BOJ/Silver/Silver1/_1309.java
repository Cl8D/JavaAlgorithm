package BOJ.Silver.Silver1;

import java.io.*;
import java.util.*;

// 동물원
public class _1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        // 우리의 세로 크기
        int n = Integer.parseInt(buf.readLine());

        // 나눠줘야 하는 값
        final int mod = 9901;

        // 사자의 마리수랑 상관없이 넣을 수 있는 방법을 고려해야 한다.
        // 사자가 0마리, 1마리, 2마리... 이런 식으로 경우 탐색
        // dp[1] = 3, dp[2] = 7, dp[3] = 17, dp[4] = 41...

        int[][] dp = new int[n+1][3];
        // dp[i][0] = i번째 줄이 비어있는 경우
        // dp[i][1] = i번째 줄에서 왼쪽칸이 채워져 있는 경우
        // dp[i][2] = i번째 줄에서 오른쪽칸이 채워져 있는 경우

        // n=1일 경우에는 비어있는 경우, 왼쪽칸, 오른쪽칸만 채워져 있는 경우가 모두 각각 1가지씩 존재해서 3이다
        dp[1][0] = dp[1][1] = dp[1][2] = 1;
        for (int i = 2; i <= n; i++) {
            // i번째 줄이 비어있기 위해서는 i-1번째 줄이 비어있든 왼쪽만 채워져있든 오른쪽만 채워져있든 상관이 없다.
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % mod;
            // 왼쪽칸만 채워져 있으려면 i-1번째 줄이 비어있거나 오른쪽칸만 채워져 있어야 한다 (겹칠 수가 없으니까)
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % mod;
            // 오른쪽칸만 채워져 있으려면 i-1번째 줄이 비어있거나 왼쪽칸만 채워져 있어야 한다.
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % mod;
        }

        System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % mod);

        buf2.flush();
        buf.close();
        buf2.close();
    }
}