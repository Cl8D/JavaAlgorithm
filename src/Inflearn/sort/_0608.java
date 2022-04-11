package Inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 8. 이분 탐색
public class _0608 {
    static int[] val;
    static int n=0, m=0;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        int[] val = new int[n];
        stk = new StringTokenizer(buf.readLine());

        for(int i=0; i<n; i++)
            val[i] = Integer.parseInt(stk.nextToken());

        Arrays.sort(val);

        for(int i=0; i<n; i++) {
            if(val[i] == m) {
                System.out.println(i+1);
                break;
            }
        }


    }
}
