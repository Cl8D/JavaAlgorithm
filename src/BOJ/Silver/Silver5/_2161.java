package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 카드 1
public class _2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            queue.add(i);
        }

        while(!queue.isEmpty()) {
            if(queue.size() == 1) {
                sb.append(queue.poll()).append(" ");
                break;
            }
            sb.append(queue.poll()).append(" ");
            queue.add(queue.poll());
        }

        buf2.write(sb.toString());

        buf2.flush();
        buf.close();
        buf2.close();

    }
}
