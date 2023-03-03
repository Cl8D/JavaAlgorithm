package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 합 구하기
public class _11441 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        int n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(stk.nextToken());
        }

        // 누적합
        int[] sum = new int[n];
        sum[0] = values[0];

        for (int i = 1; i < n; i++) {
            sum[i] = values[i] + sum[i-1];
        }

        int m = Integer.parseInt(buf.readLine());

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(buf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            if (a - 1 == 0) {
                sb.append(sum[b-1]).append("\n");
                continue;
            }
            int value = sum[b - 1] - sum[a - 2];
            sb.append(value).append("\n");
        }

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }
}
