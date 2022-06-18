package BOJ.Silver.Silver1;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 절댓값 힙
public class _11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) > Math.abs(o2))
                    return 1;
                else if(Math.abs(o1) < Math.abs(o2))
                    return -1;
                else {
                    if(o1 > o2)
                        return 1;
                    else if(o1 < o2)
                        return -1;
                    else
                        return 0;
                }
            }
        });
        int n = Integer.parseInt(buf.readLine());
        for(int i=0; i<n; i++) {
            int val = Integer.parseInt(buf.readLine());
            if(val != 0) {
                queue.add(val);
            }
            else {
                if(queue.isEmpty())
                    buf2.write("0\n");
                else
                    buf2.write(queue.poll() + "\n");
            }
        }

        buf2.flush();
        buf.close();
        buf2.close();

    }
}