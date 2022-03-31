package Inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 5. 소수 (에라토스테네스 체) - 솔루션 코드
public class _0205S {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());

        int[] val = new int[n+1];
        int count =0;

        for(int i=2; i<=n; i++) {
            if(val[i] == 0) {
                count++;
                // i=>i의 배수값 의미
                for(int j=i; j<=n; j=j+i)
                    val[j] = 1;
            }
        }

        System.out.println(count);

    }
}
