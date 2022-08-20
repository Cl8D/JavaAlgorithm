package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 퇴사
public class _14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        int[][] val = new int[n+1][2];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(buf.readLine());
            val[i][0] = Integer.parseInt(stk.nextToken());
            val[i][1] = Integer.parseInt(stk.nextToken());
        }
        int[] dp = new int[n+1];

        int max = 0;
        // 돈을 상담이 끝난 날에 받는다고 생각하기.
        // 상담 걸리는 시간 + 현재 날짜 = 지금까지 계산한 값
        // 지금까지 계산한 보수와 현재 새롭게 벌 수 있는 돈 중에 더 큰 값을 넣어주기.
        for (int i = 0; i <= n; i++) {
            // 최댓값이 들어가야 하기 때문에 max와 계속 비교해서 미리 넣어놔야 한다.
            dp[i] = Math.max(dp[i], max);
            if(val[i][0] + i <= n) // 퇴사날이 지나지 않는지 체크
                dp[val[i][0] + i] = Math.max(dp[val[i][0] + i], val[i][1] + dp[i]);
            max = Math.max(max, dp[i]); // 갱신해주기
        }

        buf2.write(max + "");
        buf2.flush();
        buf.close();
        buf2.close();

    }
}
