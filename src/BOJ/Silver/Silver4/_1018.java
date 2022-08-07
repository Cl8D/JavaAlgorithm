package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 체스판 다시 칠하기
public class _1018 {
    static int n, m;
    static String[][] val;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        val = new String[n][m];

        for (int i = 0; i < n; i++) {
            String[] split = buf.readLine().split("");
            for (int j = 0; j < m; j++) {
                val[i][j] = split[j];
            }
        }

        int answer = 5000;
        // 문제를 잘못 읽어서 상당히 고생한 문제.......
        // 8x8로 잘라낼 수 있는 모든 경우
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                answer = Math.min(answer, getAns(i, j));
            }
        }

        buf2.write(answer+"");
        buf2.flush();
        buf.close();
        buf2.close();

    }

    static int getAns(int x, int y) {
        String color = val[x][y];
        int answer = 0;

        for (int i = x; i < x+8; i++) {
            for (int j = y; j <y+8; j++) {
                if(!val[i][j].equals(color)) {
                    answer++;
                }

                if(color.equals("W"))
                    color = "B";
                else
                    color = "W";
            }
            // 행 바뀔 때 색깔이 또 변하니까
            if(color.equals("W"))
                color = "B";
            else
                color = "W";
        }
        // startColor가 동일할 경우와 그 반대의 경우 중 더 작은 경우의 수를 리턴하기
        return Math.min(answer, 64-answer);
    }
}
