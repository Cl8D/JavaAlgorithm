package BOJ.Silver.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최소 힙
public class _1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int n = Integer.parseInt(buf.readLine());
        for(int i=0; i<n; i++) {
            int val = Integer.parseInt(buf.readLine());
            if(val==0) {
                if(!queue.isEmpty())
                    System.out.println(queue.poll());
                else
                    System.out.println(0);
            }
            else
                queue.add(val);
        }

    }
}