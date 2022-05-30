package BOJ.Silver.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 팩토리얼 0의 개수
public class _1676 {
    static BigInteger[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(buf.readLine());

        dp = new BigInteger[n+1];
        if(n==0) {
            dp[0] = new BigInteger("1");
            System.out.println(0);
        }
        else if (n==1) {
            dp[0] = dp[1] = new BigInteger("1");
            System.out.println(0);
        }

        else {
            dp[0] = dp[1] = new BigInteger("1");
            for (int i = 2; i <= n; i++) {
                fac(i);
            }

            String answer = String.valueOf(dp[n]);
            StringBuilder sb = new StringBuilder(String.valueOf(dp[n]));
            answer = sb.reverse().toString();

            int count = 0;
            for(char c : answer.toCharArray()) {
                if(c=='0')
                    count++;
                else
                    break;
            }
            System.out.println(count);
        }
    }

    static BigInteger fac (int n) {
        return dp[n] = new BigInteger(String.valueOf(n)).multiply(dp[n-1]);
    }
}