package BOJ.Gold.Gold5;

import java.io.*;
import java.util.*;

// 용액
public class _2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());
        int[] liquids = new int[n];

        for (int i = 0; i < n; i++) {
            liquids[i] = Integer.parseInt(stk.nextToken());
        }

        int start = 0, end = n - 1;
        int mixture = Integer.MAX_VALUE;
        int[] answer = new int[2];

        // 두 용액이랑 거의 비슷한데, 여기는 입력이 정렬되어 들어온다는 특성이 있다.
        while (start < end) {
            int value = liquids[start] + liquids[end];

            if (Math.abs(value) < mixture) {
                mixture = Math.abs(value);
                answer[0] = liquids[start];
                answer[1] = liquids[end];
            }

            if (value < 0) {
                start++;
            } else {
                end--;
            }
        }

        sb.append(answer[0]).append(" ").append(answer[1]);
        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }
}