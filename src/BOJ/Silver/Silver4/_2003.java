package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 수들의 합 2
public class _2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] val = new int[n];
        stk = new StringTokenizer(buf.readLine());
        int answer = 0;

        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }

        int start = 0;
        int end = 0;
        int temp = 0;

        while(true) {
            if (temp >= m) {
                temp -= val[start];
                start++;
            }
            else if (end == n)
                break;
            else {
                temp += val[end];
                end++;
            }

            if (temp == m) {
                answer++;
            }
        }
        /*
        10 5
        1 2 3 4 2 5 3 1 1 2

        temp = 0, start = 0, end = 0
        temp = 1, end = 1
        temp = 3, end = 2
        temp = 6, end = 3
        temp = 5, start = 1
        ...

         */

        buf2.write(answer+"");
        buf2.flush();
        buf.close();
        buf2.close();
    }
}