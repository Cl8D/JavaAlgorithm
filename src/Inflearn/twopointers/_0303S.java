package Inflearn.twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3. 최대 매출 - 솔루션 코드
public class _0303S {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[] val = new int[n];

        stk = new StringTokenizer(buf.readLine());
        for(int i=0; i<n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }

        int answer = 0, sum = 0;
        // 가장 처음의 윈도우 값 설정
        for(int i=0; i<k; i++)
            sum += val[i];
        answer = sum;

        for(int i=k; i<n; i++) {
            // val[i] -> 다음 위치에 있는 값
            // val[i-k] -> 이전 윈도우에서 가장 처음에 있던 값
            sum += (val[i] - val[i-k]);
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);

    }
}
