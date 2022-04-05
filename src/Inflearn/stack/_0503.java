package Inflearn.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 3. 크레인 인형뽑기
public class _0503 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        int[][] board = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            stk = new StringTokenizer(buf.readLine());
            for(int j=1; j<=n; j++) {
                board[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int m = Integer.parseInt(buf.readLine());
        int[] move = new int[m];
        stk = new StringTokenizer(buf.readLine());
        for(int i=0; i<m; i++)
            move[i] = Integer.parseInt(stk.nextToken());

        Stack<Integer> stack = new Stack<>();

        int count = 0;
        for(int j=0; j<m; j++) {
            for(int i=1; i<=n; i++) {
                int top = board[i][move[j]];
                if(top != 0) {
                    if(stack.isEmpty())
                        stack.push(top);
                    else {
                        if(stack.peek() != top)
                            stack.push(top);
                        else {
                            stack.pop();
                            count++;
                        }
                    }
                    board[i][move[j]] = 0;
                    break;
                }
            }
        }

        System.out.println(count*2);

    }
}
