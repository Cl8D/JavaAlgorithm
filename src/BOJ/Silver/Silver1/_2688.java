package BOJ.Silver.Silver1;

import java.io.*;
import java.util.*;

// 줄어들지 않아
public class _2688 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        /*
        0 1 2 3 4 5 6 7 8 9 -> 10개

        00 01 02 03 04 05 06 07 08 09 -> 10
        11 12 13 14 15 16 17 18 19 -> 9
        22 23 24 25...
        -> 10+9...+1 = 55

        000 001 002 003 004... 009
        011 012 013 014... 019
        111

        0 -> 55
        1 -> 45
        2 -> 36...
        55 + 45 + 36 + 28 + 21 + 15 + 10 + 6 + 3 + 1
        = 220

        220 +
        */
        int t = Integer.parseInt(buf.readLine());
        long[][] dp = new long[65][10];

        // 초기값
        int count = 10;
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
            dp[2][i] = count--;
        }


        for (int i = 3; i <= 64; i++) {
            for (int j = 0; j < 10; j++) {
                if (j==0) {
                    for (int k = 0; k < 10; k++) {
                        dp[i][0] += dp[i-1][k];
                    }
                    continue;
                }
                dp[i][j] = dp[i][j-1] - dp[i-1][j-1];
            }

        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(buf.readLine());
            long answer = 0;
            for (int j = 0; j < 10; j++) {
                answer += dp[n][j];
            }
            sb.append(answer).append("\n");
        }
        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }
}