package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 풍선 터뜨리기
public class _2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        int n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());
        Deque<Type> deque = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            int v = Integer.parseInt(stk.nextToken());
            deque.addLast(new Type(i, v));
        }

        int answer = 1;
        Type current = deque.pollFirst();
        int temp = current.val;
        sb.append(current.idx).append(" ");

        while(!deque.isEmpty()) {
            if (answer == Math.abs(temp)) {
                if (temp > 0)
                    current = deque.poll();
                else
                    current = deque.pollLast();
                temp = current.val;
                sb.append(current.idx).append(" ");
                answer = 1;
                continue;
            }
            if (temp > 0)
                deque.addLast(deque.pollFirst());
            else {
                deque.addFirst(deque.pollLast());
            }
            answer++;
        }
        /*

        answer = 1
        current = (3, 1)
        temp = 3
        sb = 1

        current = (-3, 4)
        temp = -3
        sb = 1 4
        answer = 1

        current = (-1, 5)
        temp = -1
        sb = 1 4 5
        answer = 1

        current = (1, 3)
        temp = 1
        sb = 1 4 5 3
        answer = 1

         */

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }

    static class Type {
        int idx;
        int val;

        public Type(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}