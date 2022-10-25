package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 2차원 배열의 합
public class _2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[][] val = new int[n][m];

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(buf.readLine());
            for (int j = 0; j < m; j++) {
                val[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int k = Integer.parseInt(buf.readLine());
        for (int t = 0; t < k; t++) {
            stk = new StringTokenizer(buf.readLine());
            int i = Integer.parseInt(stk.nextToken()) - 1;
            int j = Integer.parseInt(stk.nextToken()) - 1;
            int x = Integer.parseInt(stk.nextToken()) - 1;
            int y = Integer.parseInt(stk.nextToken()) - 1;
            int answer = 0;

            for (int p = i; p <= x; p++) {
                for (int q = j; q <= y; q++) {
                    answer += val[p][q];
                }
            }
            sb.append(answer).append("\n");
        }

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }
}

///** 너무 어렵게 생각해서 틀린 느낌...? ㅠ 그냥 쉽게 가는 게 나을 것 같다.*/
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer stk;
//        StringBuilder sb = new StringBuilder("");
//
//        stk = new StringTokenizer(buf.readLine());
//        int n = Integer.parseInt(stk.nextToken());
//        int m = Integer.parseInt(stk.nextToken());
//
//        int[][] val = new int[n][m];
//
//        for (int i = 0; i < n; i++) {
//            stk = new StringTokenizer(buf.readLine());
//            for (int j = 0; j < m; j++) {
//                val[i][j] = Integer.parseInt(stk.nextToken());
//            }
//        }
//
//        // 누적합 저장
//        int[][] dp = new int[n][m];
//        dp[0][0] = val[0][0];
//
//        // 초기값 세팅
//        for (int i = 1; i < n; i++) {
//            dp[i][0] = dp[i-1][0] + val[i][0];
//        }
//
//        for (int i = 1; i < m; i++) {
//            dp[0][i] = dp[0][i-1] + val[0][i];
//        }
//
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < m; j++) {
//                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + val[i][j];
//            }
//        }
//
//        int k = Integer.parseInt(buf.readLine());
//        for (int i = 0; i < k; i++) {
//            // 구간합 구하기
//            stk = new StringTokenizer(buf.readLine());
//            int a = Integer.parseInt(stk.nextToken()) - 1;
//            int b = Integer.parseInt(stk.nextToken()) - 1;
//            int x = Integer.parseInt(stk.nextToken()) - 1;
//            int y = Integer.parseInt(stk.nextToken()) - 1;
//
//            // 1 2 4
//            // 8 16 32
//
//            // 1 3 7
//            // 9 27 63
//
//            // a b x y
//            // 1 0 2 0
//
//            // 1
//            // 2
//            // 3
//
//            // 1 0
//
//            int answer = dp[x][y];
//
//            if (a != 0 && b != 0) {
//                answer = answer - dp[0][y] - dp[x][0] + dp[a-1][b-1];
//            }
//            if (a == 0 && b != 0) {
//                answer -= dp[x-a][b-1];
//            }
//            if (a != 0 && b == 0) {
//                answer -= dp[a-1][y-b];
//            }
//
//            sb.append(answer).append("\n");
//        }
//
//        buf2.write(sb.toString());
//
//        /*
//        1 1 2
//        1 2 1
//        1 3 2
//        ---
//        누적합
//
//        1 2 4
//        2 5 8
//        3 9 14
//
//        8 + 9 - 5 + 2
//
//        ---
//        구간합
//
//        답 8 (1,1 ~ 2, 2)
//        전체 14 (0,0 ~ 2,2)
//        4 (0,0 ~ 0,2)
//        3 (0,0 ~ 2,0)
//        1 (0,0 ~ 1,1
//
//        14 - 4 - 3 + 1
//         */
//
//
//        buf2.flush();
//        buf.close();
//        buf2.close();
//    }
//}