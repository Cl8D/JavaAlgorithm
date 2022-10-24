package BOJ.Silver.Silver1;

import java.io.*;
import java.util.*;

// 최대공약수
public class _1850 {
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");


        stk = new StringTokenizer(buf.readLine());
        long a = Long.parseLong(stk.nextToken());
        long b = Long.parseLong(stk.nextToken());

        for (int i = 0; i < gcd(a, b); i++) {
            sb.append(1);
        }

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }

    static long gcd(long a, long b) {
        if (b==0) {
            return a;
        }
        return gcd(b, a%b);
    }
}