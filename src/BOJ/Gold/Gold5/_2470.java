package BOJ.Gold.Gold5;

import java.io.*;
import java.util.*;

// 두 용액
public class _2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        // 같은 양의 두 용액을 혼합한 용액의 특성값 = 혼합에 사용된 각 용액의 특성값의 합
        // 특성값이 0에 가까운 용액을 만드는 것이 목표.

        int n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());
        int[] liquids = new int[n];

        for (int i = 0; i < n; i++) {
            liquids[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(liquids);

        // -99 -2 -1 4 98
        int start = 0, end = n - 1;
        int value = Integer.MAX_VALUE;
        int[] answer = new int[2];

        // start <= end로 처음에 설정했었는데, 이러면 start와 end값이 동일해졌을 때도 실행되면서
        // 두 용액이 아니라 같은 용액에 대해서 참조할 수도 있게 되어버린다.
        while (start < end) {
            // 용액의 특성값
            int sum = liquids[start] + liquids[end];

            if (Math.abs(sum) < value) {
                value = Math.abs(sum);
                answer[0] = liquids[start];
                answer[1] = liquids[end];
            }

            // 0보다 작은 경우, 더 큰 값이랑 혼합해주기
            if (sum < 0) {
                start++;
            } else {
                // 더 크다면 더 작은 값이랑 혼합
                end--;
            }

        }

        System.out.println(answer[0] + " " + answer[1]);
        buf2.flush();
        buf.close();
        buf2.close();
    }
}