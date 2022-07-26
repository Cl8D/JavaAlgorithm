package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 회전하는 큐
public class _1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        // 큐의 크기
        int n = Integer.parseInt(stk.nextToken());
        // 뽑아내려는 원소의 개수
        int m = Integer.parseInt(stk.nextToken());

        // 처음에 deque 자체를 사용했었는데, 인덱스 기능을 쓰기 위해 linkedList 사용!
        LinkedList<Integer> deque = new LinkedList<>();

        for(int i=1; i<=n; i++)
            deque.add(i);

        stk = new StringTokenizer(buf.readLine());
        // 뽑아내려는 수의 위치가 순서대로

        int answer = 0;

        for(int i=0; i<m; i++) {
            int v = Integer.parseInt(stk.nextToken());
            while(deque.getFirst() != v) {
                if(deque.indexOf(v) < deque.size() - deque.indexOf(v)) {
                    deque.addLast(deque.pollFirst());
                    answer++;
                }
                else {
                    deque.addFirst(deque.pollLast());
                    answer++;
                }
            }
            deque.pollFirst();
        }
        buf2.write(answer+"");
        buf2.flush();
        buf.close();
        buf2.close();

    }
}
