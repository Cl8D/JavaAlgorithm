package BOJ.Gold.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 용액 합성하기
public class _14921 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(stk.nextToken());
        }

        int start = 0, end = n - 1;
        int sum = Integer.MAX_VALUE;
        int answer = 0;

        while (start < end) {
            int mid = values[start] + values[end];
            int before = sum;
            sum = Math.min(Math.abs(mid), sum);
            if (before != sum) {
                answer = mid;
            }

            if (mid < 0) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(answer);
        buf.close();
    }
}
