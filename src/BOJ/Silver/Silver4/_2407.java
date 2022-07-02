package BOJ.Silver.Silver4;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 조합
public class _2407 {
    static BigInteger[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        dp = new BigInteger[101];

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        dp[1] = new BigInteger("1");

        for(int i=2; i<=100; i++) {
            fac(i);
        }

        BigInteger answer = dp[n].divide(dp[n-m].multiply(dp[m]));
        buf2.write(answer+"");

        buf2.flush();
        buf.close();
        buf2.close();

    }

    static BigInteger fac (int n) {
        return dp[n] = dp[n-1].multiply(BigInteger.valueOf(n));
    }
}
