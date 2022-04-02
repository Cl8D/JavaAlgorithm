package Inflearn.twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 6. 최대 길이 연속부분수얼 - 솔루션 코드 참고
public class _0306 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(buf.readLine());
        int[] val = new int[n];

        for(int i=0; i<n; i++)
            val[i] = Integer.parseInt(stk.nextToken());

        int lt=0;
        int chCount = 0;
        int result = 0;

        for(int rt=0; rt<n; rt++) {
            if(val[rt] == 0)
                // 1로 바꿔준 횟수
                chCount++;

            // 1로 바꿔준 횟수가 k를 초과했으면
            while(chCount > k) {
                // lt를 증가시켜가며 이전에 바꿨을 위치를 취소해주며
                // chCount를 감소시켜준다.
                if (val[lt] == 0)
                    chCount--;
                lt++;
            }

            // 이렇게 chCount가 k를 넘지 않는다는 조건 + 조정된 lt 위치를 이용해서
            // 현재 1의 길이를 구해준다 (rt-lt+1)
            result = Math.max(result, rt-lt+1);

        }
        System.out.println(result);
    }
}
