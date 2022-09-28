package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 신나는 함수 실행
public class _9184 {
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        dp = new int[101][101][101];

        while(true) {
            stk = new StringTokenizer(buf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());

            if (a==-1 && b==-1 && c==-1)
                break;

            w(a, b, c);

            int newA = a <= 0 ? 50 + Math.abs(a) : a;
            int newB = b <= 0 ? 50 + Math.abs(b) : b;
            int newC = c <= 0 ? 50 + Math.abs(c) : c;

            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ")
                    .append(dp[newA][newB][newC]).append("\n");
        }
        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }

    static int w (int a, int b, int c) {
        if (a <= 0 || b<=0 || c <= 0) {
            int newA = a <= 0 ? 50 + Math.abs(a) : a;
            int newB = b <= 0 ? 50 + Math.abs(b) : b;
            int newC = c <= 0 ? 50 + Math.abs(c) : c;

            return dp[newA][newB][newC] = 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return dp[a][b][c] = dp[20][20][20] == 0 ? w(20, 20, 20) : dp[20][20][20];
        }
        if ((a < b) && (b < c)) {
            dp[a][b][c-1] = dp[a][b][c-1] == 0 ? w(a, b, c-1) : dp[a][b][c-1];
            dp[a][b-1][c-1] = dp[a][b-1][c-1] == 0 ? w(a, b-1, c-1) : dp[a][b-1][c-1];
            dp[a][b-1][c] = dp[a][b-1][c] == 0 ? w(a, b-1, c) : dp[a][b-1][c];
            return dp[a][b][c] = dp[a][b][c-1] + dp[a][b-1][c-1] -  dp[a][b-1][c];
        }
        dp[a-1][b][c] = dp[a-1][b][c] == 0 ? w(a-1, b, c) : dp[a-1][b][c];
        dp[a-1][b-1][c] = dp[a-1][b-1][c] == 0 ? w(a-1, b-1, c) : dp[a-1][b-1][c];
        dp[a-1][b][c-1] = dp[a-1][b][c-1] == 0 ? w(a-1, b, c-1) : dp[a-1][b][c-1];
        dp[a-1][b-1][c-1] = dp[a-1][b-1][c-1] == 0 ? w(a-1, b-1, c-1) : dp[a-1][b-1][c-1];
        return dp[a][b][c] = dp[a-1][b][c] +  dp[a-1][b-1][c] + dp[a-1][b][c-1] -  dp[a-1][b-1][c-1];
    }
}