package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 소수
public class _1312 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        stk = new StringTokenizer(buf.readLine());
        int a = Integer.parseInt(stk.nextToken());
        int b = Integer.parseInt(stk.nextToken());
        int n = Integer.parseInt(stk.nextToken());

        int result = a % b;

        // 그 다음 자리수 찾는 과정...
        for (int i = 0; i < n - 1; i++) {
            result *= 10;
            result %= b;
        }
        result *= 10;
        System.out.println(result/b);
        buf2.flush();
        buf.close();
        buf2.close();
    }
}