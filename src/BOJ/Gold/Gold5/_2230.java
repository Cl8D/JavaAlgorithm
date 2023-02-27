package BOJ.Gold.Gold5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 수 고르기
public class _2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(buf.readLine());
        }


        Arrays.sort(values);

        int answer = Integer.MAX_VALUE;
        // 투 포인터 알고리즘
        int start = 0, end = 0;

        // 1 3 5
        while (end < n) {
            int sub = values[end] - values[start];
            if (sub == m) {
                answer = m;
                break;
            }

            if (sub < m) {
                end++;
                continue;
            }

            answer = Math.min(answer, sub);
            start++;
        }

        System.out.println(answer);


    }

}

