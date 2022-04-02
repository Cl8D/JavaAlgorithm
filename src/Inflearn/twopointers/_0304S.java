package Inflearn.twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연속 부분수열 - 솔루션 코드
public class _0304S {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(buf.readLine());

        int[] val = new int[n];

        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }

        // two pointer + sliding window까지 함께 이용해서
        // 더 효율적으로 구현한 방법 (temp에 다음 값을 더해주고, 이전값을 빼주는 전략까지 추가)
        int count = 0;
        int lt = 0;
        int temp = 0;

        // 전반적인 과정
        // 1) 더해지는 값이 m보다 작은 경우 -> rt를 증가시키면서 temp에 값 추가해주기
        // 그러다 m인 지점 발견 -> count 증가
        // 2) 더해지는 값이 m보다 큰 경우 -> lt를 증가시키면서 temp에서 이전 부분 빼주기
        // 그러다 m인 지점 발견 -> count 증가
        for(int rt=0; rt<n; rt++) {
            temp += val[rt];
            if(temp == m)
                count++;
            // 임시로 더한값이 m보다 크면 lt값을 이동시키면서
            // temp에서 빼주기
            while(temp >= m) {
                // 값을 빼주고 나서, lt값 증가(후위연산자)
                temp -= val[lt++];
                // 빼주면서 m인 경우가 존재하면 count 증가
                if(temp == m)
                    count++;
            }
        }
        System.out.println(count);
    }
}
