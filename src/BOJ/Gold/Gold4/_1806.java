package BOJ.Gold.Gold4;

import java.io.*;
import java.util.*;

// 부분합
public class _1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int s = Integer.parseInt(stk.nextToken());

        int[] values = new int[n];
        stk = new StringTokenizer(buf.readLine());
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(stk.nextToken());
        }

        int start = 0, end = 0;
        int answer = Integer.MAX_VALUE;

        int sum = 0;
        while (true) {
            // 문제를.. 잘못 읽었다..... 합이 S 이상이 되는 것 중인데 S인 것인 줄......
            if (sum >= s) {
                answer = Math.min(answer, end - start);
                sum -= values[start++];
            } else if (end == n) {
                // 10 10
                // 1 1 1 1 1 1 1 1 1 10
                // 위 예제를 처리해줘야 주려면 여기서 해야 한다....
                break;
            } else {
                sum += values[end++];
            }
        }

        if (answer == Integer.MAX_VALUE) {
            answer = 0;
        }

        System.out.println(answer);
        buf2.flush();
        buf.close();
        buf2.close();
    }
}
