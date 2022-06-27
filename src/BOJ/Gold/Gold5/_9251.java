package BOJ.Gold.Gold5;

import java.io.*;
import java.util.StringTokenizer;

// LCS
public class _9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        // dp는 정말 너무 어려운 것 같다...
        // https://st-lab.tistory.com/139

        // 만약 x==y라면 왼쪽 대각선 요소의 +1
        // x!=y라면, 왼쪽과 위쪽에 있는 요소 중에 더 큰 값으로...

        String s1 = buf.readLine();
        String s2 = buf.readLine();

        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int i=1; i<=s1.length(); i++) {
            for(int j=1; j<=s2.length(); j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        buf2.write(dp[s1.length()][s2.length()] + "");
        buf2.flush();

        buf.close();
        buf2.close();
    }
}