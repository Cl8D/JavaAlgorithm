package BOJ.Silver.Silver2;

import java.io.*;
import java.util.StringTokenizer;

// 안녕
public class _1535 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        // 세준이의 체력 100, 기쁨 0
        // 체력이 0이나 음수가 되면 죽음
        int n = Integer.parseInt(buf.readLine());

        // 각각의 사람에게 인사할 때 잃는 체력
        int[] hp = new int[n+1];
        stk = new StringTokenizer(buf.readLine());
        for (int i = 1; i <= n; i++) {
            hp[i] = Integer.parseInt(stk.nextToken());
        }

        int[] happy = new int[n+1];
        // 얻는 기쁨
        stk = new StringTokenizer(buf.readLine());
        for (int i = 1; i <= n; i++) {
            happy[i] = Integer.parseInt(stk.nextToken());
        }

        // dp[a][b] = a번째 사람과 인사했을 때, 체력이 k인 상황의 최대 기쁨
        int[][] dp = new int[n+1][101];

        for (int i = 1; i <= n; i++) {
            // 배낭문제 풀이 시 배낭에 넣을 수 없다면 이전의 최적의 값을 그대로,
            // 배낭에 넣을 수 있다면 현재 물건을 넣거나 이전 물건을 넣었을 때의 최대 가치를 유지하ㅣㄱ.
            for (int j = 1; j <= 100; j++) {
                // 넣을 수 있는 경우
                int temp = j - hp[i];
                if (temp >= 0) {
                    dp[i][j] = Math.max(dp[i-1][temp] + happy[i], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        buf2.write(dp[n][99] + "");
        buf2.flush();
        buf.close();
        buf2.close();
    }
}