package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 링
public class _3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        int n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());
        int[] val = new int[n];
        for (int i = 0; i <n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }
        int start = val[0];
        for (int i = 1; i < n; i++) {
            int gcd = gcd(start, val[i]);
            sb.append(start / gcd).append("/").append(val[i] / gcd).append("\n");
        }
        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }

    // 최대공약수 구하기
    static int gcd(int p, int q) {
        if (q == 0)
            return p;
        return gcd(q, p%q);
    }
}