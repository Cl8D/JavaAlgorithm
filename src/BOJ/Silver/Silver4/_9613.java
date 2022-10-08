package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// GCD 합
public class _9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        int t = Integer.parseInt(buf.readLine());
        for (int i = 0; i < t; i++) {
            stk = new StringTokenizer(buf.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int[] val = new int[n];
            long answer = 0;

            for (int j = 0; j < n; j++) {
                val[j] = Integer.parseInt(stk.nextToken());
            }

            for (int j = 0; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    answer += gcd(val[j], val[k]);
                }
            }
            sb.append(answer).append("\n");
        }

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }

    // 유클리드 호제법
    // gcd(10, 20)
    // gcd(20, 10)
    // gcd(10, 0) = 10
    static int gcd(int x, int y) {
        if (y==0) {
            return x;
        }
        return gcd(y, x%y);
    }
}