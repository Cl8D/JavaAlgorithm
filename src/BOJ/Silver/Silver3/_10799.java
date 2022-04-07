package BOJ.Silver.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        char[] cArr = buf.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

        int result = 0;

        for(int i=0; i<cArr.length; i++) {
            if(cArr[i] == '(')
                stack.push(cArr[i]);
            else {
                // 레이저인지 판단
                if(cArr[i-1] == '(') {
                    stack.pop();
                    result += stack.size();
                }
                else {
                    // 막대기일 때
                    // 마지막 남은 한 조각 추가 후 stack에서 제거
                    result += 1;
                    stack.pop();
                }
            }
        }
        System.out.println(result);
    }
}
