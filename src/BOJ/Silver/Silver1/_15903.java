package BOJ.Silver.Silver1;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 카드 합체 놀이
public class _15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(buf.readLine());
        PriorityQueue<Long> queue = new PriorityQueue<>();

        // 시간 제한 빡셈 => 선형으로 연산 가능한 큐 사용하기
        for(int i=0; i<n; i++) {
            queue.add(Long.valueOf(stk.nextToken()));
        }

        // 범위 잘 살펴보기 ㅠㅠ int형으로 하면 범위 초과남!
        long answer = 0;

        for(int i=0; i<m; i++) {
            long sum = queue.poll() + queue.poll();
            queue.add(sum);
            queue.add(sum);
        }

        while(!queue.isEmpty())
            answer += queue.poll();

        buf2.write(answer+"");
        buf2.flush();
        buf.close();
        buf2.close();


    }
}
