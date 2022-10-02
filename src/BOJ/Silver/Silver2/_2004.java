package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 조합 0의 개수
public class _2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        // 0으로 끝나기 위해서는 2와 5가 곱해져있는 경우
        // = 2와 5의 승수가 겹치는 수가 존재해야 한다.

        // nCm = n! / (n-m)!m!
        // n! = (2^a1 * 5^a2)
        // (n-m)! = (2^b1 * 5^b2)
        // m! = (2^c1 * 5^c2)
        // ==> 2^(a1-b1-c1) * 5^(a2-b2-c2)

        // 이 둘 중에서 더 작은 값이 곧 0의 개수가 된다.
        // https://lucian-blog.tistory.com/85
        // 이게 그나마 이해하기 쉬운 것 같다... ㅠ
        long temp1 = count2(n) - count2(n-m) - count2(m);
        long temp2 = count5(n) - count5(n-m) - count5(m);

        System.out.println(Math.min(temp1, temp2));

        buf2.flush();
        buf.close();
        buf2.close();
    }

    // 2의 배수의 개수를 세는 함수
    static long count2 (int val) {
        long answer = 0;
        while (val >= 2) {
            answer += (val / 2);
            val /= 2;
        }

        return answer;
    }

    // 소인수분해 했을 때 5의 지수값을 구하는 메서드
    // 63을 예로 들면, 5로 나누었을 때 나오는 값들에서 5를 한 번 더 나눠서 개수 구하기...
    // 5로 나누어 떨어지는 값: 60*55*50*...*10*5
    // 12*11*10* ...* 2*1 => 12개
    // 2*1 => 2개
    // 총 14개

    // 음 약간 120이 들어왔다면 5^2 * 2^2니까 여기서 2를 구하는 방법 (5의 지수)
    // 그냥 소인수분해 수식을 그대로 따라 쓴거라고 생각하면 된다.
    static long count5 (int val) {
        long answer = 0;
        while(val >= 5) {
            answer += (val / 5);
            val /= 5;
        }
        return answer;
    }

}