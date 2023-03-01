package BOJ.Gold.Gold2;

import java.io.*;
import java.util.*;

// K번째 수
public class _1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        /**
         * 1 2 3
         * 2 4 6
         * 3 6 9
         *
         * --> 1 2 3 2 4 6 3 6 9
         * --> 1 2 2 3 3 4 <6> 6 9
         */
        // B[7] = 6 -> 6보다 작거나 같은 원소의 개수는 7개이다.

        /**
         * 1 2 3 4
         * 2 4 6 8
         * 3 6 9 12
         * 4 8 12 16
         *
         * --> 1 2 2 3 3 4 4 4 6 6 8 8 9 12 12 16
         */

        int n = Integer.parseInt(buf.readLine());
        int k = Integer.parseInt(buf.readLine());

        // B[k]가 오름차순 정렬이기 때문에, 이분 탐색 활용 가능
        long start = 0, end = k;
        long answer = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            long count = 0;
            for (int i = 1; i <= n; i++) {
                // 배열에서 i 이하인 값들의 개수 = 배열에서 i행 이하의, 모든 행의 열 개수의 합과 동일하다.
                // 우리가 지금 구해야 하는 값 = (정답)보다 작거나 같은 원소의 개수가 k라는 것.
                // 작거나 같은 원소의 개수가 k인 지점을 찾아야 하는 것이다.

                // 이때, mid보다 작거나 같은 것의 개수를 구하기 위해서는,
                // nxn 배열에서 각 행을 기준으로 생각했을 때,
                // (mid / i)개만큼이 나오게 된다.

                // 이때, 각 행에 있는 개수는 최대 n까지이기 때문에 두 값을 비교해서 더 작은 값을 더해줘야 한다.
                count += Math.min(mid / i, n);
            }

            if (count < k) {
                start = mid + 1; // 더 큰 값 탐색
            } else {
                answer = mid;
                end = mid - 1;
            }
        }

        System.out.println(answer);
        buf2.flush();
        buf.close();
        buf2.close();
    }
}
