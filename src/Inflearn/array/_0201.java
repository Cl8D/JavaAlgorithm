package Inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1. 큰 수 출력하기
public class _0201 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());

        StringTokenizer stk = new StringTokenizer(buf.readLine());
        int[] val = new int[n];

        for(int i=0; i<n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }

        int temp = 0;

        for(int v : val) {
            if(temp < v)
                System.out.print(v + " ");
            temp = v;
        }
    }
}
