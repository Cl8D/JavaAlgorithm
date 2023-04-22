package BOJ.Gold.Gold3;

import java.io.*;
import java.util.*;

// 세 용액
public class _2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(values);

        int[] answer = new int[3];
        long min = Long.MAX_VALUE;

        // -97 -6 -2 6 98
        for (int target : values) {
            int start = 0, end = values.length - 1;
            while (start < end) {
                if (target == values[start]) {
                    start++;
                    continue;
                }
                if (target == values[end]) {
                    end--;
                    continue;
                }

                long sum = values[start] + values[end];
                long liquid = sum + target;

                if (liquid == 0) {
                    answer[0] = target;
                    answer[1] = values[start];
                    answer[2] = values[end];
                    printResult(buf2, sb, answer);
                    return;
                }

                if (Math.abs(liquid) < min) {
                    answer[0] = target;
                    answer[1] = values[start];
                    answer[2] = values[end];
                    min = Math.abs(liquid);
                }

                if (liquid > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        printResult(buf2, sb, answer);
        buf.close();
        buf2.close();
    }

    private static void printResult(final BufferedWriter buf2,
                                    final StringBuilder sb,
                                    final int[] answer) throws IOException {
        Arrays.sort(answer);
        for (final int ans : answer) {
            sb.append(ans).append(" ");
        }
        buf2.write(sb.toString());
        buf2.flush();
    }
}
