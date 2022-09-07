package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 배열 합치기
public class _11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        stk = new StringTokenizer(buf.readLine());
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(stk.nextToken()));
        }
        stk = new StringTokenizer(buf.readLine());
        for (int i = 0; i < m; i++) {
            queue.add(Integer.parseInt(stk.nextToken()));
        }

        StringBuffer sb = new StringBuffer("");
        while(!queue.isEmpty()) {
            sb.append(queue.poll()).append(" ");
        }
        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }
}
