package BOJ.Silver.Silver5;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 피보나치 수 4
public class _10826 {
    static BigInteger[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n  = Integer.parseInt(buf.readLine());
        dp = new BigInteger[10001];

        dp[1] = dp[2] = new BigInteger("1");
        for(int i=3; i<= 10000; i++)
            fibo(i);

        if(n==0)
            buf2.write(0+"");
        else
            buf2.write(dp[n] + "");
        buf2.flush();
        buf.close();
        buf2.close();

    }

    static void fibo(int n) {
        dp[n] = dp[n - 1].add(dp[n-2]);
    }
}
