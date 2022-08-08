package BOJ.Silver.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다이나믹이 뭐예요?
public class _14494 {
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        dp = new long[1001][1001];

        for(int i=1; i<=1000; i++) {
            for(int j=1; j<=1000; j++) {
                if(i==1 && j!=1)
                    dp[i][j] = 1;
                else if(i!=1 && j==1)
                    dp[i][j] = 1;
            }
        }

        // 초기값 설정
        dp[1][1] = 1;
        dp[2][2] = 3;

        for(int i=1; i<=1000; i++) {
            for(int j=1; j<=1000; j++) {
                if((i==1 && j!=1) || (i!=1 && j==1) || (i==2 && j==2) || (i==1 && j==1))
                    continue;
                recur(i, j);
            }
        }
        System.out.println(dp[n][m]);
    }

    static long recur(int i, int j) {
        // 나중에 결과에서만 나눠주면 오버플로우가 난 상태로 계속 연산하는 거니까 미리미리 나눠줘야 한다
        return dp[i][j] = (dp[i-1][j] + dp[i][j-1] + dp[i-1][j-1]) % 1000000007;
    }

}