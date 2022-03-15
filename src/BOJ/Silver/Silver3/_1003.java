package BOJ.Silver.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(buf.readLine());

        int[] test = new int[t];

        for (int i = 0; i < t; i++)
            test[i] = Integer.parseInt(buf.readLine());

        for(int i=0; i<t; i++) {
            int dp[][] = new int[test[i]+1][2];

            if(test[i] == 0)
                System.out.println(1 + " " + 0);
            else if (test[i] == 1)
                System.out.println(0 + " " + 1);
            else {
                // 그래서 dp로 다시 풀었다...!
                dp[0][0] = 1;
                dp[0][1] = 0;

                dp[1][0] = 0;
                dp[1][1] = 1;

                for(int j=2; j<=test[i]; j++) {
                    dp[j][0] = dp[j-1][0] + dp[j-2][0];
                    dp[j][1] = dp[j-1][1] + dp[j-2][1];
                }
                System.out.println(dp[test[i]][0] + " " + dp[test[i]][1]);
            }

        }
    }

    // 재귀로 푼 방법 -> 시간 초과 나온다.
        /*
        for(int i=0; i<t; i++) {
            int dp[] = new int[test[i]+1];

            fibonacci(test[i], dp);

            if(test[i]==0)
                System.out.println(dp[0] + " " + 0);
            else
                System.out.println(dp[0] + " " + dp[1]);
        }

    }


    public static int fibonacci(int n, int[] dp) {
        if(n==0) {
            dp[0]++;
            return 0;
        }
        else if(n==1) {
            dp[1]++;
            return 1;
        }
        else {
            dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);
            return dp[n];
        }
    }
    */
}
