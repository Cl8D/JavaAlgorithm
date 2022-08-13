package BOJ.Silver.Silver1;

import java.io.*;
import java.util.*;

// 하노이 탑 이동 순서
public class _11729 {
    static StringBuilder sb = new StringBuilder("");
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        /**
         * 1 -> 1번
         * 2 -> 3번 (2^2-1)
         * 3 -> 7번 (2^3 -1)
         * 4 -> 15번 (2^4-1)
         */
        sb.append((int)Math.pow(2, n) -1).append("\n");
        hanoi(n, 1, 2, 3);
        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();

    }

    /**
     * 규칙)
     * A -> C로 이동한다고 했을 때
     * 1. 작은 원반 n-1개를 A->B로 이동시키기
     * 2. 큰 원반 1개를 A->C로 이동시키기
     * 3. 작은 원반 n-1개를 B->C로 이동시키기
     * 참고) https://brenden.tistory.com/31
     *
     * = 원반 n개를 이동하는 문제가 n-1개로 이동하는 문제로 세분화,
     * 결국 원반 1개를 이동하는 문제로 귀결된다.
     */
    // start에 있는 n개의 원반을 mid를 거쳐 end로 이동시키자.
    static void hanoi(int n, int start, int mid, int end) {
        if(n==1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }

        // n-1개를 A->B로 이동시키기
        // A->B로 이동시키는 과정도 일련의 하노이 탑 이동 과정이기 때문에 재귀함수가 호출된다.
        hanoi(n-1, start, end, mid);

        // 큰 원반 1개를 A->C로 이동시켜준다.
        sb.append(start).append(" ").append(end).append("\n");

        // 작은 원반 n-1개를 B->C로 이동시키기.
        // mid 지점의 n-1개의 원반을 end로 옮기기.
        // 마찬가지로 일련의 과정이기 때문에 재귀함수가 호출된다.
        hanoi(n-1, mid, start, end);
    }


}
