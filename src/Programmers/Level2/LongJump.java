package Programmers.Level2;

// 멀리 뛰기
class LongJump {
    private static final int VAL = 1234567;
    public long solution(int n) {
        long[] dp = new long[n+1];

        if (n<3) {
            return n;
        }

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1] % VAL + dp[i-2] % VAL;
        }

        return dp[n] % VAL;
    }
}