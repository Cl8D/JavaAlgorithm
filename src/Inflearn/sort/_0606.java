package Inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 6. 장난꾸러기
public class _0606 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        int[] val = new int[n];
        int[] val2 = new int[n];
        stk = new StringTokenizer(buf.readLine());

        for(int i=0; i<n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
            val2[i] = val[i];
        }

        Arrays.sort(val);

        int a=0,b=0, aIdx=0, bIdx=0;

        for(int i=0; i<n; i++) {
            if(val[i] != val2[i]) {
                if(b==0) {
                    b = val[i];
                    bIdx = i+1;
                }
                else {
                    if(a < val[i]) {
                        a = b;
                        aIdx = bIdx;
                        b = val[i];
                        bIdx = i+1;
                    }
                }
            }
        }

        System.out.print(aIdx + " " + bIdx);


    }
}
