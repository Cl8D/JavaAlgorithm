package BOJ.Silver.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());

        int[] score = new int[n+1];

        score[0] = 0;

        for(int i=1; i<=n; i++) {
            score[i] = Integer.parseInt(buf.readLine());
        }

        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = score[1];

        // n=2 이상인 조건 안 주면 런타임 에러 발생
        if(n>=2)
            dp[2] = score[1] + score[2];

        for(int i=3; i<=n; i++){
            // 여기서 dp[i-1]의 값을 사용하게 된다면
            // 이전 계단 (n-3)을 밟은 상태인지 알 수 없기 때문에 score 배열의 값을 사용
            dp[i] = Math.max(dp[i-3] + score[i-1], dp[i-2]) + score[i];
        }

        System.out.println(dp[n]);
    }
}
