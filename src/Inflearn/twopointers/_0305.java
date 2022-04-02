package Inflearn.twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 5. 연속된 자연수의 합
public class _0305 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());


        int[] val = new int[n+1];
        for(int i=1; i<=n; i++) {
            val[i] = i;
        }

        int lt = 1;
        int temp = val[lt];
        int count = 0;

        for(int rt=2; rt<n; rt++) {
            temp += val[rt];

            if(temp == n)
                count++;

            while(temp >= n) {
                temp -= val[lt++];
                if(temp == n)
                    count++;
            }
        }

        System.out.println(count);
    }
}
