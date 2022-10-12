package BOJ.Gold.Gold5;

import java.io.*;
import java.util.*;

// 탑
public class _2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());

        int[] val = new int[n];
        for(int i=0; i<n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        int[] answer = new int[n];

        for(int i=0; i<n; i++) {
            if(stack.isEmpty())
                stack.add(i);
            else {
                while (!stack.isEmpty()) {
                    if (val[stack.peek()] > val[i]) {
                        answer[i] = stack.peek() + 1;
                        stack.add(i);
                        break;
                    } else {
                        stack.pop();
                    }
                }
                stack.add(i);
            }
        }

        for(int a : answer)
            buf2.write(a + " ");
        buf2.flush();
        buf.close();
        buf2.close();

    }
}
