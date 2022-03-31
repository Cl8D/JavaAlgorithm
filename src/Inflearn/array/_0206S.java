package Inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 6. 뒤집은 소수 - 솔루션 코드
public class _0206S {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());

        StringTokenizer stk = new StringTokenizer(buf.readLine());
        int[] val = new int[n];

        for(int i=0; i<n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
            int temp = val[i];

            // 뒤집기
            int res = 0;
            while(temp > 0) {
                // 뒤에서부터 자릿수 가져오기
                int t = temp % 10;
                // res에 가져온 자릿수를 뒤집어서 나타날 수 있도록
                res = res*10 + t;
                temp /= 10;
            }

            // 소수 판정
            if (isPrime(res))
                System.out.print(res + " ");
        }
    }

    public static boolean isPrime(int num) {
        if (num==1)
            return false;
        for(int i=2; i<num; i++) {
            // 2부터 자기 자신 전까지 약수가 존재해버린다면
            if (num%i==0)
                return false;
        }
        return true;
    }

}
