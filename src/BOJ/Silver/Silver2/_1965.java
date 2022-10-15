package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 상자넣기
public class _1965 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        int n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());

        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        /*
        dp[1] = 2
        dp[2] = 2
        dp[3] = 3

        dp[1]
        - val[0] < val[1] = dp[0] + 1 = 2

        dp[2]
        - val[0] < val[2] = dp[0] + 1 = 2, 0
        - val[1] < val[2] = false

         */

        /*
         예외 케이스)
         5
         4 5 1 2 3

         dp[0] = 1

         dp[1]
         - val[0] < val[1] = 2

         dp[2]
         - val[0] < val[2] = false
         - val[1] < val[2] = false.

         -> 상자 하나만 뽑는 경우도 있기 때문에 초기 배열이 1로 초기화되어 있어야 한다.
         */

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (val[j] < val[i]) {
                    // 이전의 수에 대한 최대 개수 + 1, 현재까지 비교해온 dp랑 비교해서 더 큰 값!
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        buf2.write(Arrays.stream(dp).max().getAsInt() + "");
        buf2.flush();
        buf.close();
        buf2.close();
    }
}