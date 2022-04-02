package Inflearn.twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 4. 연속 부분수열 - 시간초과 최적화 코드
public class _0304_2 {
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

        int lt=0, rt=0;
        int temp = 0;
        int count = 0;

        while(rt < n) {
            if(temp < m) {
                temp += val[rt++];
            }
            else if (temp == m) {
                count++;
                lt++;
                rt=lt;
                temp=0;
            }
            else {
                lt++;
                rt = lt;
                temp = 0;
            }
        }
        // 마지막 수에 대해서도 처리
        if (temp == m)
            count++;

        System.out.println(count);

    }
}
