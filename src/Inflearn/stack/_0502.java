package Inflearn.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _0502 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        char[] cArr = buf.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

        for(char c : cArr) {
            if(c == ')') {
                while(stack.peek() != '(') {
                    stack.pop();
                }
                stack.pop();
            }
            else {
                stack.push(c);
            }
        }

        String result = "";
        while(!stack.isEmpty()){
            result += String.valueOf(stack.pop());
        }

        StringBuilder sb;
        sb = new StringBuilder(result);
        System.out.println(sb.reverse().toString());

        /*
            cf) StringBuilder 사용하지 않고 출력하기
            stack은 get으로 접근이 가능하다!
            for(int i=0; i<stack.size(); i++)
                result += stack.get(i);
         */

    }
}
