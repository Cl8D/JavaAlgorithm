
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        char[] cArr = buf.readLine().toCharArray();

        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for(char c : cArr) {
            if (Character.isDigit(c))
                stack.push(Character.getNumericValue(c));
            else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int temp = 0;
                if(c == '+')
                    temp = num2+num1;
                else if (c=='-')
                    temp = num2-num1;
                else if (c=='*')
                    temp = num2*num1;
                else
                    temp = num2/num1;

                stack.push(temp);
                result = temp;
            }
        }

        System.out.println(result);

    }

}
