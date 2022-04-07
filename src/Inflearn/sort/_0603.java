package Inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3. 삽입 정렬
public class _0603 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(buf.readLine());

        int[] val = new int[n];
        stk = new StringTokenizer(buf.readLine());

        for(int i=0; i<n; i++)
            val[i] = Integer.parseInt(stk.nextToken());

        for(int i=1; i<n; i++) {
            int temp = val[i], j;
            for(j=i-1; j>=0; j--) {
                if (temp < val[j])
                    val[j+1] = val[j];
                else
                    break;
            }
            val[j+1] = temp;
        }


        for(int v : val)
            System.out.print(v + " ");



    }
}
