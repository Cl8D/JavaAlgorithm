package BOJ.Gold.Gold2;

import java.io.*;
import java.util.StringTokenizer;

// 피보나치 수 3
public class _2749 {
    static long[] val;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        // 이 문제는 피사노 주기를 사용해서 풀어야 함!
        // 주기의 길이가 P일 때 N번째 피보나치 수를 M으로 나눈 나머지는
        // N%P번째 피보나치 수를 M으로 나눈 나머지와 같다

        // M = 10^k (k>2)일 때, 주기는 항상 15*10^(k-1)이다.
        // 여기서 M=1000000이기 때문에 k=6, 주기는 15*10^5 = 1500000

        val = new long[1500001];
        val[1] = 1;
        val[2] = 1;

        long n = Long.parseLong(buf.readLine());

        for(int i=3; i<=1500000; i++)
            fibo(i);

        buf2.write(val[(int)(n%1500000)] + "");

        buf2.flush();
        buf.close();
        buf2.close();

    }

    // 피보나치에서 큰 수 구할 때 % 적용한 결과 넣어주는 거 잊지 말기...!
    static void fibo(int n) {
        val[n] = (val[n - 1] + val[n - 2]) % 1000000;
    }
}