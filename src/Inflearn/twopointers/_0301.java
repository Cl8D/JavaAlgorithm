package Inflearn.twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1. 두 배열 합치기
public class _0301 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        int[] array1 = new int[n];

        for(int i=0; i<n; i++)
            array1[i] = Integer.parseInt(stk.nextToken());

        int m = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());

        int[] array2 = new int[n+m];
        for(int i=0; i<n; i++) {
            array2[i] = array1[i];
        }

        for(int i=n; i<n+m; i++) {
            array2[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(array2);

        for(int a : array2)
            System.out.print(a + " ");
    }
}
