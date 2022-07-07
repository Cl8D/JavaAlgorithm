package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 좋은 단어
public class _3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        int answer = 0;
        for(int i=0; i<n; i++) {
            String str = buf.readLine();
            Stack<Character> stack = new Stack<>();

            for(Character c : str.toCharArray()) {
                if(stack.isEmpty())
                    stack.add(c);
                else {
                    if(stack.peek() == c)
                        stack.pop();
                    else
                        stack.add(c);
                }
            }

            if(stack.isEmpty())
                answer++;
        }


        buf2.write(answer+"");
        buf2.flush();
        buf.close();
        buf2.close();

    }
}
