package BOJ.Silver.Silver3;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

// 후위 표기식2
public class _1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        String str = buf.readLine();

        Stack<Double> stack = new Stack<>();
        int[] val = new int[n];
        for(int i=0; i<n; i++)
            val[i] = Integer.parseInt(buf.readLine());


        for(char c : str.toCharArray()) {
            if(Character.isAlphabetic(c))
                stack.add((double) val[c - 65]);
            else {
                double answer;
                double a = stack.pop();
                double b = stack.pop();
                if(c=='+')
                    answer = (a+b);
                else if(c=='-')
                    answer = (b-a);
                else if(c=='*')
                    answer = (a*b);
                else
                    answer = b/a;
                stack.add(answer);
            }
        }


        System.out.printf("%.2f", stack.peek());

        buf2.flush();
        buf.close();
        buf2.close();

    }
}
