package Inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 6. 뒤집은 소수
public class _0206 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());

        StringTokenizer stk = new StringTokenizer(buf.readLine());
        StringBuilder sb;
        int[] val = new int[n];
        int[] sortVal = new int[n];

        for(int i=0; i<n; i++) {
            String temp = stk.nextToken();
            sb = new StringBuilder(temp);
            val[i] = Integer.parseInt(sb.reverse().toString());
            sortVal[i] = val[i];
        }

        // 최댓값 구하기 용도
        Arrays.sort(sortVal);
        int max = sortVal[n-1];

        // 소수 판정하기
        int[] prime = new int[max+1];
        prime[0] = 1;

        if(max > 1)
            prime[1]= 1;

        for(int i=2; i<=max; i++) {
            if (prime[i] == 0) {
                for(int j= i * 2; j<=max; j=j+i)
                    prime[j] = 1;
            }
        }

        for(int v: val) {
            if (prime[v] == 0)
                System.out.print(v + " ");
        }
    }
}
