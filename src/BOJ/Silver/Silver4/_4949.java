package BOJ.Silver.Silver4;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

// 균형잡힌 세상
public class _4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        while(true) {
            String s = buf.readLine();
            if(s.equals("."))
                break;

            // 반복문 시간 때문에 문자랑 공백은 없애줬음
            s = s.replaceAll("[a-zA-Z]", "");
            s = s.replaceAll(" ", "");

            // 처음에 스택 두 개로 나눠서 생각했었는데, 그러면 ([)] 이런 걸 못 잡음!
            // 문제를 제대로 읽어야 할 것 같다... ㅎㅎ 저런 경우도 된다고 생각했었는데 아니었음! 들어온 순서 맞춰야 한다는 것!
            Stack<Character> stack = new Stack<>();
            boolean flag = false;

            for(char c: s.toCharArray()) {
                if(c == '(')
                    stack.push(c);
                else if(c=='[')
                    stack.push(c);
                else if(c==')') {
                    // 2트...
                    // 두 개로 나눈 이유는 [))))] 이런 경우 때문에! )가 들어왔는데 스택이 비어있으면 곧 잘못된 문자열이라는 거니까
                    if(!stack.isEmpty() && stack.peek() == '(')
                        stack.pop();
                    else {
                        flag = true;
                        break;
                    }
                }
                else if(c==']') {
                    if(!stack.isEmpty() && stack.peek() == '[')
                        stack.pop();
                    else {
                        flag = true;
                        break;
                    }
                }
            }

            if(stack.isEmpty() && !(flag))
                buf2.write("yes\n");
            else
                buf2.write("no\n");
        }


        buf2.flush();
        buf.close();
        buf2.close();
    }
}
