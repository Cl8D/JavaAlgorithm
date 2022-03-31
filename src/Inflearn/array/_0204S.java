package Inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 피보나치 수열 - 솔루션 코드
public class _0204S {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());

        /*
        // 굳이 함수 선언 안 하고 푸는 방법
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for (int i = 2; i < n; i++)
            answer[i] = answer[i - 1] + answer[i - 2];

        for (int a : answer)
            System.out.print(a + " ");
        */

        // 아니면 아예 배열조차도 안 쓰는 방법
        int a=1, b=1, c;
        System.out.print(a + " " + b + " ");
        for(int i=2; i<n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a=b;
            b=c;
        }
    }

}
