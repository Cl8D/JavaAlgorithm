package BOJ.Silver.Silver2;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

// 스택 수열
public class _1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] val = new int[n];

        for(int i=0; i<n; i++) {
            int v = Integer.parseInt(buf.readLine());
            val[i] = v;
        }

        int temp = 0; // 스택에 넣은 적 있는 최댓값
        StringBuilder sb = new StringBuilder("");

        for(int i=0; i< val.length; i++) {
            if(i==0) {
                // 가장 처음 숫자만큼 push 우선 진행해주기
                for(int j=1; j<=val[i]; j++) {
                    stack.add(j);
                    sb.append("+\n");
                }
                temp = val[i];
                stack.pop();
                sb.append("-\n");
            }
            else {
                if(!stack.isEmpty() && val[i] == stack.peek()) {
                    stack.pop();
                    sb.append("-\n");
                }
                else {
                    if(temp <= val[i]) {
                        for(int j=temp+1; j<=val[i]; j++){
                            stack.add(j);
                            sb.append("+\n");
                        }
                        temp = val[i];
                        stack.pop();
                        sb.append("-\n");
                    }
                    else {
                        sb = new StringBuilder("NO");
                        break;
                    }
                }
            }
        }
        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }
}
