package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 수리공 항승
public class _1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        // 물이 새는 곳의 개수
        int n = Integer.parseInt(stk.nextToken());
        // 테이프의 길이
        int l = Integer.parseInt(stk.nextToken());

        int[] val = new int[n];

        stk = new StringTokenizer(buf.readLine());
        for (int i = 0; i < n; i++) {
            // 물이 새는 곳의 위치
            val[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(val);

        int temp = val[0];
        int answer = 1;

        for (int i = 1; i < n; i++) {
            int tape = val[i] - temp + 1; // 0.5씩 더한 결과
            if(tape > l) {
                temp = val[i];
                answer++;
            }
        }

        buf2.write(answer+"");
        buf2.flush();
        buf.close();
        buf2.close();

    }
}
