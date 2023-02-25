package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 게임
public class _1072 {
    private static final int MAX = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        stk = new StringTokenizer(buf.readLine());
        int x = Integer.parseInt(stk.nextToken());
        int y = Integer.parseInt(stk.nextToken());

        int start = 0, end = MAX;
        int rate = calculateRate(x, y);
        int answer = -1;

        while (start <= end) {
            // 몇 번을 더 해야 하는지
            int mid = (start + end) / 2;
            int current = calculateRate(x + mid, y + mid);

            if (current != rate) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(answer);
        buf2.flush();
        buf.close();
        buf2.close();
    }

    private static int calculateRate(int count, int total) {
        return (int) ((long) total * 100 / count);
    }
}