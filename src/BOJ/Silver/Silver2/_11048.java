package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 이동하기
public class _11048 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int[][] dp = new int[n][m];
        int[][] val = new int[n][m];

        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            for(int j=0; j<m; j++) {
                val[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        dp[0][0] = val[0][0];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i==0 && j==0)
                    continue;

                if(i==0) {
                    dp[i][j] = val[i][j] + dp[i][j-1];
                }
                else if(j==0) {
                    dp[i][j] = val[i][j] + dp[i-1][j];
                }
                else {
                    Integer[] temp = new Integer[3];
                    temp[0] = dp[i][j-1];
                    temp[1] = dp[i-1][j];
                    temp[2] = dp[i-1][j-1];

                    Arrays.sort(temp, Collections.reverseOrder());
                    dp[i][j] = val[i][j] + temp[0];
                }
            }
        }

        buf2.write(dp[n-1][m-1] + "");

        buf2.flush();
        buf.close();
        buf2.close();

    }
}
