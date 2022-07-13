package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 덱
public class _10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        Deque<Integer> deque = new LinkedList<>();
        int n = Integer.parseInt(buf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            String oper = stk.nextToken();
            int val = 0;

            if(stk.hasMoreTokens())
                val = Integer.parseInt(stk.nextToken());

            switch (oper) {
                case "push_front" :
                    deque.addFirst(val);
                    break;
                case "push_back" :
                    deque.addLast(val);
                    break;
                case "pop_front" :
                    if(deque.isEmpty())
                        sb.append("-1");
                    else
                        sb.append(deque.pollFirst());
                    sb.append("\n");
                    break;
                case "pop_back" :
                    if(deque.isEmpty())
                        sb.append("-1");
                    else
                        sb.append(deque.pollLast());
                    sb.append("\n");
                    break;
                case "size" :
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty" :
                    if(deque.isEmpty())
                        sb.append("1\n");
                    else
                        sb.append("0\n");
                    break;
                case "front" :
                    if(deque.isEmpty())
                        sb.append("-1");
                    else
                        sb.append(deque.peekFirst());
                    sb.append("\n");
                    break;
                case "back" :
                    if(deque.isEmpty())
                        sb.append("-1");
                    else
                        sb.append(deque.peekLast());
                    sb.append("\n");
                    break;
            }
        }

        buf2.write(sb.toString());

        buf2.flush();
        buf.close();
        buf2.close();

    }
}
