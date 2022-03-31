package Inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 피보나치 수열
public class _0204 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());

        int dp[] = new int[n+1];
        for(int i=1; i<=n; i++)
            fibonacci(dp, i);

        for(int d: dp)
            if (d != 0)
                System.out.print(d + " ");

    }

    static void fibonacci(int[] dp, int n) {
        if(n==0) {
            dp[0] = 0;
        }
        else if (n==1) {
            dp[1] = 1;
        }
        else {
            dp[n] = dp[n-1] + dp[n-2];
        }
    }
}
