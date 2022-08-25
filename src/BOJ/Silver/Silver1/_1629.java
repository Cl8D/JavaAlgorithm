package BOJ.Silver.Silver1;

import java.io.*;
import java.util.*;

// 곱셈
public class _1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        // 지수 법칙
        // a^(n+m) = a^n * a^m
        // 모듈러 성질
        // (axb)%C = (a%C * b%C) % C

        stk = new StringTokenizer(buf.readLine());
        long a = Long.parseLong(stk.nextToken());
        long b = Long.parseLong(stk.nextToken());
        long c = Long.parseLong(stk.nextToken());

        buf2.write(multi(a, b, c) + "");

        buf2.flush();
        buf.close();
        buf2.close();

    }

    static long multi(long a, long b, long c) {
        // 지수가 1일 때까지 = a^1= a 그 자체
        if (b==1)
            return a % c;

        // 지수를 반으로 나눠주기
        long temp = multi(a, b/2, c);

        // 이때, 지수가 홀수면
        // a^11 = a^5 * a^5 * a 형태로, 반으로 나눠준 거에 한 번 더 a를 곱해줘야 함
        if(b%2 == 1)
            // 이때, a, b, c 수가 매우 크기 때문에 모듈러 성질을 이용해줘야 한다.
            // (a, b 자체가 int형 최대치인데 둘을 곱해주면 long으로도 커버가 안 됨)
            return ((temp*temp)%c * (a%c))%c;

        // 짝수라면 그냥 그대로
        return ((temp%c) * (temp%c))%c;
    }
}
