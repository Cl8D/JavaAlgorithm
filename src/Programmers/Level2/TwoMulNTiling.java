package Programmers.Level2;

// 2 x n 타일링
class TwoMulNTiling {
    private static final int CONST = 1_000_000_007;
    public int solution(int n) {
        int[] dp = new int[n+1];
        if (n == 1 || n == 2) {
            return n;
        }

        dp[1] = 1; dp[2] = 2;

        for (int i=3; i<=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % CONST;
        }

        return dp[n];
    }
}
