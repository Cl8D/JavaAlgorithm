package BOJ.Silver.Silver1;

import java.io.*;
import java.util.*;

// 정수 삼각형
public class _1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        int[][] val = new int[n][n];

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(buf.readLine());
            for(int j = 0; j < n; j++) {
                if(stk.hasMoreTokens())
                    val[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = val[0][0];
        int answer = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i-1>=0)
                    dp[i][j] = Math.max(dp[i][j] + val[i][j], dp[i-1][j] + val[i][j]);
                if(i-1 >=0 && j-1 >=0)
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]  + val[i][j]);
                answer = Math.max(answer, dp[i][j]);
            }
        }

        buf2.write(answer+"");
        buf2.flush();
        buf.close();
        buf2.close();

    }
}
