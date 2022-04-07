package Inflearn.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 8. 응급실
public class _0508 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] pat = new int[n];
        stk = new StringTokenizer(buf.readLine());
        for(int i=0; i<n; i++)
            pat[i] = Integer.parseInt(stk.nextToken());

        // 내림차순으로 우선순위 큐
        PriorityQueue<Integer> wait = new PriorityQueue<>(Collections.reverseOrder());

        for(int p : pat)
            wait.add(p);

        // 진료를 받은 순서
        int order = 1;

        /*
        peek = 90 ==> 발견 i=2 <-> k=3
        우리가 찾는 애는 아니지만 진료 완료. answer=1
        70 ==> i=3~i=length까지 돌았지만 x -> while문으로 인해 한 번 더 참색
        i=1 <-> k=3 => answer=2

        60 ==> 발견 i=2 <-> k=3 <-> answer=3
        60 ==> 발견 i=3 <-> k=3 <-> answer=4
         */
        while(!wait.isEmpty()) {
            for(int i=0; i< pat.length; i++) {
                if(wait.peek() == pat[i]) {
                    if(i==m) {
                        System.out.println(order);
                        return;
                    }
                    else {
                        order++;
                        wait.poll();
                    }
                }
            }
        }

    }
}
