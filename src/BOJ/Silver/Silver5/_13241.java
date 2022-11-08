package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 최소공배수
public class _13241 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        stk = new StringTokenizer(buf.readLine());
        long a = Long.parseLong(stk.nextToken());
        long b = Long.parseLong(stk.nextToken());

        long multi = a * b;
        long gcd = 0;

        if (a < b) {
            gcd = gcd(b, a);
        } else {
            gcd = gcd(a, b);
        }

        // 최소공배수
        long answer = multi / gcd;

        buf2.write(answer+"");
        buf2.flush();
        buf.close();
        buf2.close();
    }

    // 최대공약수
    static long gcd(long p, long q) {
        if (q == 0) {
            return p;
        }
        return gcd(q, p%q);
    }
}