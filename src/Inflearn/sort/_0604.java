package Inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 4. Least Recently Used
public class _0604 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        int s = Integer.parseInt(stk.nextToken());
        int n = Integer.parseInt(stk.nextToken());

        int[] work = new int[n];


        stk = new StringTokenizer(buf.readLine());
        for(int i=0; i<n; i++)
            work[i] = Integer.parseInt(stk.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<n; i++) {
            if(queue.contains(work[i])) {
                int cnt = 0;
                int size = queue.size();
                while(cnt < size) {
                    if (!queue.isEmpty() && queue.peek() == work[i])
                        queue.poll();
                    else
                        queue.add(queue.poll());
                    cnt++;
                }
                queue.add(work[i]);
            }
            else {
                if (queue.size() < s)
                    queue.add(work[i]);
                else {
                    queue.poll();
                    queue.add(work[i]);
                }
            }
        }

        int[] result = new int[queue.size()];
        int idx = 0;

        while(!queue.isEmpty())
            result[idx++] = queue.poll();

        for(int i= result.length-1; i>=0; i--) {
            System.out.print(result[i] + " ");
        }

    }
}
