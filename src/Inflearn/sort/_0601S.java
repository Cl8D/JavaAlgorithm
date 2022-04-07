package Inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1. 선택 정렬
public class _0601S {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(buf.readLine());

        int[] val = new int[n];
        stk = new StringTokenizer(buf.readLine());

        for(int i=0; i<n; i++)
            val[i] = Integer.parseInt(stk.nextToken());

        for(int i=0; i<n-1; i++) {
            int idx = i;
            for(int j=i+1; j<n; j++) {
                if (val[i] < val[idx])
                    idx = j;
                int temp = val[i];
                val[i] = val[idx];
                val[idx] = temp;
            }
        }

        for(int v : val)
            System.out.print(v + " ");
    }
}
