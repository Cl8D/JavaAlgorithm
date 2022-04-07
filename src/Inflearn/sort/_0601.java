package Inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1. 선택 정렬
public class _0601 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(buf.readLine());

        int[] val = new int[n];
        stk = new StringTokenizer(buf.readLine());

        for(int i=0; i<n; i++)
            val[i] = Integer.parseInt(stk.nextToken());

        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                int temp  = 0;
                if(val[i] > val[j]) {
                    temp = val[i];
                    val[i] = val[j];
                    val[j] = temp;
                }
            }
        }

        for(int v : val)
            System.out.print(v + " ");
    }
}
