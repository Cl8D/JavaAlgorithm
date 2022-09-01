package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 수 이어 쓰기 1
public class _1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        if (n < 10) {
            buf2.write(n+"");
        }
        else {
            int length = String.valueOf(n).length();
            long answer = 9;
            long basic = (long) Math.pow(10, (length - 1));
            for (int i = 2; i <= length; i++) {
                if (i == length)
                    answer += (n - basic + 1) * length;
                else {
                    long temp = (long) (Math.pow(10, i) - Math.pow(10, i - 1));
                    answer += temp * i;
                }
            }
            buf2.write(answer+"");
        }

        buf2.flush();
        buf.close();
        buf2.close();

    }
}
