package Inflearn.twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 4. 연속 부분수열 - 답은 맞지만 시간 최적화 x
public class _0304 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(buf.readLine());

        int[] val = new int[n];

        for(int i=0; i<n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }

        int window = 1;
        int count = 0;

        while(window < n) {
            int temp = 0;

            // 초기값 설정
            for(int i=0; i<window; i++)
                temp += val[i];

            for(int i=window; i<n; i++) {
                temp += (val[i] - val[i-window]);

                if(temp == m)
                    count++;
            }
            window++;
        }

        System.out.println(count);

    }
}
