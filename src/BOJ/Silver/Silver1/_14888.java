package BOJ.Silver.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연산자 끼워넣기
public class _14888 {
    private static int n, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    private static final String[] OP = {"+", "-", "*", "/"};
    private static String[] operators;
    private static int[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());
        values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(stk.nextToken());
        }

        stk = new StringTokenizer(buf.readLine());
        operators = new String[n - 1];
        int index = 0;
        for (int i = 0; i < 4; i++) {
            int count = Integer.parseInt(stk.nextToken());
            for (int j = 0; j < count; j++) {
                operators[index++] = OP[i];
            }
        }

        recur(0);
        System.out.println(max);
        System.out.println(min);

        buf.close();
    }

    private static void recur(int depth) {
        if (depth == operators.length) {
            final int result = sum(operators);
            min = Math.min(result, min);
            max = Math.max(result, max);
            return;
        }

        for (int i = depth; i < operators.length; i++) {
            swap(operators, depth, i);
            recur(depth + 1);
            swap(operators, depth, i);
        }
    }

    private static void swap(String[] oper, int i, int j) {
        String temp = oper[i];
        oper[i] = oper[j];
        oper[j] = temp;
    }

    private static int sum(String[] oper) {
        int result = values[0];
        for (int i = 1; i < n; i++) {
            result = calculate(oper[i-1], values[i], result);
        }
        return result;
    }

    private static int calculate(String operator, int value, int result) {
        if (operator.equals("+")) {
            return result + value;
        }
        if (operator.equals("-")) {
            return result - value;
        }
        if (operator.equals("*")) {
            return result * value;
        }
        if (result < 0) {
            int temp = (-1 * result) / value;
            return -1 * temp;
        }
        return result / value;
    }
}
