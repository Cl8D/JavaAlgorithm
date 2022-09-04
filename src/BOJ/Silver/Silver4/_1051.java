package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 숫자 정사각형
public class _1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[][] val = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] split = buf.readLine().split("");
            for (int j = 0; j < m; j++) {
                val[i][j] = Integer.parseInt(split[j]);
            }
        }

        // 정사각형의 최대 길이
        int length = Math.min(n, m); // 3

        while (length > 0) {
            for (int i = 0; i <= n - length; i++) {
                for (int j = 0; j <= m - length; j++) {
                    int num = val[i][j]; // 0 2
                    if (num == val[i][j + length - 1] && num == val[i + length - 1][j]
                            && num == val[i + length - 1][j + length - 1]) { // 0 4, 2 2, 2 4
                        System.out.println(length * length);
                        return; // 바로 실행 종료
                    }
                }
            }
            length--;
        }

        buf2.flush();
        buf.close();
        buf2.close();

    }
}
