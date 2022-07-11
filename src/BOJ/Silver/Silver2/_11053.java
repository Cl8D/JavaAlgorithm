package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 가장 긴 증가하는 부분 수열
public class _11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());
        int[] val = new int[n];
        int[] dp = new int[n];

        for(int i=0; i<n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }

        // LIS 알고리즘 사용하기
        for(int i=0; i<n; i++) {
            dp[i] = 1;
            for(int j=0; j<i; j++) {
                if(val[i] > val[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        Arrays.sort(dp);
        int answer = dp[n-1];

        buf2.write(answer+"");

        buf2.flush();
        buf.close();
        buf2.close();

    }
}
