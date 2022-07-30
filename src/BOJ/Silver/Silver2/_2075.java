package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// N번째 큰 수
public class _2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());

        PriorityQueue<Integer> queue
                = new PriorityQueue<>(Collections.reverseOrder());

        // 자꾸 n번째로 큰 수라고 봐서 이해를 못했던 문제 (오름차순이라고 생각함)
        // 내림차순으로 n번째 큰 수라고 생각해야 한다...!
        // 사실 이런 정렬 문제는 우선순위 큐 사용해서 푸는 게 좋은 것 같다.
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(buf.readLine());
            for (int j = 0; j < n; j++) {
                queue.add(Integer.parseInt(stk.nextToken()));
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = queue.poll();
        }

        buf2.write(answer+"");
        buf2.flush();
        buf.close();
        buf2.close();

    }
}
