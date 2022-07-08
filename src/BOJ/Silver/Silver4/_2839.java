package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 설탕 배달
public class _2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        int[] dp = new int[5001];
        Arrays.fill(dp, 9999);

        dp[3] = dp[5] = 1;

        for(int i=6; i<=5000; i++) {
            dp[i] = Math.min(dp[i-3] + 1, dp[i-5] + 1);
        }

        // 9999 이상일 경우로 잡아줘야 한다...
        // i==7일 때 생각해보면 3과 5를 뺐을 때 결과가 둘 다 9999여서 10000이 나오기 때문... ㅎㅎ
        if(dp[n] >= 9999)
            buf2.write("-1");
        else
            buf2.write(dp[n]+"");

        buf2.flush();
        buf.close();
        buf2.close();

    }
}

