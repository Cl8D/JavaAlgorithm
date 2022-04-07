package Inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2. 버블 정렬
public class _0602 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(buf.readLine());

        int[] val = new int[n];
        stk = new StringTokenizer(buf.readLine());

        for(int i=0; i<n; i++)
            val[i] = Integer.parseInt(stk.nextToken());

        // 버블 정렬 - 이웃한 두 수 비교
        // n=5라면
        // i=0일 때 idx=4 결정, i=1일 때 idx=3 결정...
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-i-1; j++) {
                if(val[j] > val[j+1]) {
                    int temp = val[j];
                    val[j] = val[j+1];
                    val[j+1] = temp;
                }
            }
        }

        for(int v : val)
            System.out.print(v + " ");

    }
}
