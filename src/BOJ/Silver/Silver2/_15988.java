package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 1, 2, 3 더하기 3
public class _15988 {
    static final int max = 1000000, rest = 1000000009;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        int t = Integer.parseInt(buf.readLine());
        long[] dp = new long[max+1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        /*
        1 -> 1
        (1)

        2 -> 2
        [1+1]
        [2]

        3 -> 4
        <1+1+1>
        <2+1>
        <1+2>
        <3>

        4 -> 7
        <1+1+1>+1 => 끝에 1이 붙는 경우
        <2+1>+1
        <1+2>+1
        <3>+1

        [1+1]+2 => 끝에 2가 붙는 경우
        [2]+2

        (1)+3 => 끝에 3이 붙는 경우

        5 -> 13
        1+1+1+1+1
        2+1+1+1
        1+2+1+1
        3+1+1
        1+1+2+1
        2+2+1
        1+3+1

        1+1+1+2
        2+1+2
        1+2+2
        3+2

        1+1+3
        2+3
        */

        for (int i = 4; i <= max; i++) {
            // 다 더하고 한 번에 해도 어차피 분배법칙에 의해서 가능하다.
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % rest;
        }
        for (int i = 0; i < t; i++) {
            int v = Integer.parseInt(buf.readLine());
            sb.append(dp[v]).append("\n");
        }

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }
}