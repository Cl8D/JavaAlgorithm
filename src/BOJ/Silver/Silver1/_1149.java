package BOJ.Silver.Silver1;

import java.io.*;
import java.util.*;

// RGB거리
public class _1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        int[][] dp = new int[n][3];
        int[][] val = new int[n][3];

        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            for(int j=0; j<3; j++) {
                val[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        dp[0][0] = val[0][0];
        dp[0][1] = val[0][1];
        dp[0][2] = val[0][2];

        // 어차피 RGB 3가지밖에 없다는 점을 처음에 인식하지 못하고 있다가 헤맸다...
        // 가장 처음 집이 R일 경우 G일 경우 B일 경우를 각각 나눠서 생각하면 되는 것!
        for(int i=1; i<n; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + val[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + val[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + val[i][2];
        }

        Arrays.sort(dp[n-1]);
        buf2.write(dp[n-1][0] + "");

        buf2.flush();
        buf.close();
        buf2.close();

    }
}
