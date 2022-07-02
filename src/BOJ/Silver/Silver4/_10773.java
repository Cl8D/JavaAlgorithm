package BOJ.Silver.Silver4;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

// 제로
public class _10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int k = Integer.parseInt(buf.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<k; i++) {
            int val = Integer.parseInt(buf.readLine());
            if(val == 0)
                stack.pop();
            else
                stack.add(val);
        }

        int answer = 0;
        while(!stack.isEmpty()) {
            answer += stack.pop();
        }

        buf2.write(answer+"");

        buf2.flush();
        buf.close();
        buf2.close();

    }
}
