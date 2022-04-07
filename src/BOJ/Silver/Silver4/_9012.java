package BOJ.Silver.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());

        for(int i=0; i<n; i++) {
            Stack<Character> stack = new Stack<>();

            char[] cArr = buf.readLine().toCharArray();

            int cnt = 0;

            for(char c : cArr) {
                if (c == '(')
                    stack.push(c);
                else {
                    if(!stack.isEmpty())
                        stack.pop();
                    else {
                        cnt++;
                        System.out.println("NO");
                        break;
                    }
                }
            }

            if(cnt == 0) {
                if (stack.isEmpty())
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }

    }
}
