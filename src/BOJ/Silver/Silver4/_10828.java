package BOJ.Silver.Silver4;

import java.io.*;
import java.util.StringTokenizer;

// 스택
public class _10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        int[] val = new int[10000];
        int idx = 0;

        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            String oper = stk.nextToken();

            if(oper.equals("push")) {
                int v = Integer.parseInt(stk.nextToken());
                val[idx++] = v;
            }
            else if(oper.equals("pop")) {
                if(val[0] == 0)
                    buf2.write("-1\n");
                else {
                    buf2.write(val[--idx] + "\n");
                    val[idx] = 0;
                }
            }
            else if(oper.equals("size")) {
                buf2.write(idx + "\n");
            }
            else if(oper.equals("empty")) {
                if(val[0] == 0)
                    buf2.write("1\n");
                else
                    buf2.write("0\n");
            }
            else {
                if(val[0] == 0)
                    buf2.write("-1\n");
                else
                    buf2.write(val[idx-1] + "\n");
            }

        }
        buf2.flush();
        buf.close();
        buf2.close();
    }
}