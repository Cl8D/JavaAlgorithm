package BOJ.Gold.Gold4;

import java.io.*;
import java.util.*;

// 카드 정렬하기
public class _1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(buf.readLine()));
        }

        // 원래 백트래킹으로 하나하나 해보려고 했는데, 생각해보니까 n이 너무 커서...
        // 우선순위 큐를 통해서 작은 것끼리 계속 더해내가는 식으로 진행하였다!
        int answer = 0;
        while(!queue.isEmpty()) {
            if(queue.size() == 1) {
                break;
            }
            int val = queue.poll() + queue.poll();
            answer += val;
            queue.add(val);
        }

        buf2.write(answer + "");
        buf2.flush();
        buf.close();
        buf2.close();

    }



}
