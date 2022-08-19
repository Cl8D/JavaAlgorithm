package BOJ.Silver.Silver5;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

// 다리 놓기
public class _1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int t = Integer.parseInt(buf.readLine());
        BigInteger[] dp = new BigInteger[31];
        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");
        for (int i = 2; i <= 30; i++) {
            dp[i] = dp[i-1].multiply(new BigInteger(String.valueOf(i)));
        }

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < t; i++) {
            stk = new StringTokenizer(buf.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());
            // 조합 구하기
            // m! / (m-n)!n!

            int mn = m-n;
            BigInteger answer = dp[m].divide(dp[mn].multiply(dp[n]));
            sb.append(answer).append("\n");
        }

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();

    }

}
