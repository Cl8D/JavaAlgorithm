package Inflearn.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 6. 공주 구하기
public class _0506 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=n; i++)
            queue.add(i);

        int count = 1;
        while(queue.size() > 1) {
            if(count == k) {
                queue.remove();
                count = 1;
            }
            else {
                count++;
                int poll = queue.poll();
                queue.add(poll);
            }
        }

        System.out.println(queue.poll());


    }
}
