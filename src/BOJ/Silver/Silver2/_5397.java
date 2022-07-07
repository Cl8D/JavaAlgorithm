package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 키로거
public class _5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int t = Integer.parseInt(buf.readLine());
        for(int i=0; i<t; i++) {
            String str = buf.readLine();
            Stack<Character> stack = new Stack<>();
            StringBuilder answer = new StringBuilder("");
            StringBuilder sb = new StringBuilder("");
            for(Character c : str.toCharArray()) {
                if(c == '<') {
                    if(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                }
                else if(c=='-') {
                    if(!stack.isEmpty())
                        stack.pop();
                }
                else if(c == '>') {
                    if(sb.length() != 0) {
                        int idx = sb.toString().length() - 1;
                        stack.add(sb.charAt(idx));
                        sb.deleteCharAt(idx);
                    }
                }
                else {
                    stack.add(c);
                }
            }

            while(!stack.isEmpty()) {
                answer.append(stack.pop());
            }

            buf2.write(answer.reverse()+"");
            buf2.write(sb.reverse()+"");
            buf2.write("\n");
        }


        buf2.flush();
        buf.close();
        buf2.close();

    }
}
