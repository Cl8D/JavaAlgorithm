package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 두 수의 합
public class _3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        int n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());
        int[] val = new int[n];

        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }

        // 1 2 3 5 7 9 10 11 12
        Arrays.sort(val);

        // ai + aj = x를 만족하는 쌍의 수
        int x = Integer.parseInt(buf.readLine());
        int answer = 0;

        int start = 0, end = n-1;

        while (start < end) {
            int sv = val[start];
            int ev = val[end];

            int sum = sv + ev;

            if (sum < x) {
                start++;
            } else if (sum > x) {
                end--;
            } else {
                answer++;
                start++;
            }
        }

        buf2.write(answer+"");


        buf2.flush();
        buf.close();
        buf2.close();
    }
}