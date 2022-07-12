package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 큐 2
public class _18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());

        StringBuilder sb = new StringBuilder("");
        Queue<Integer> queue = new LinkedList<>();
        int back = -1;

        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            String oper = stk.nextToken();
            int val = 0;

            if(stk.hasMoreTokens())
                val = Integer.parseInt(stk.nextToken());

            if(oper.equals("push")) {
                queue.add(val);
                back = val;
            }
            else if(oper.equals("front")) {
                if(queue.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(queue.peek()).append("\n");
            }
            else if(oper.equals("back")) {
                if (queue.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(back).append("\n");
            }
            else if(oper.equals("size"))
                sb.append(queue.size()).append("\n");
            else if(oper.equals("empty")) {
                if(queue.isEmpty())
                    sb.append("1\n");
                else
                    sb.append("0\n");
            }
            else {
                if(queue.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(queue.poll()).append("\n");
            }
        }

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();

    }
}
