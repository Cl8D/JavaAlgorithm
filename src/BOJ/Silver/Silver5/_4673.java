package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 셀프 넘버
public class _4673 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        boolean[] dp = new boolean[10001];

        for(int i=1; i<=10000; i++) {
            if(i<10) {
                dp[i+i] = true;
            }
            else {
                String[] split = String.valueOf(i).split("");
                int newVal = i;
                for (String s : split) {
                    newVal += Integer.parseInt(s);
                }
                if (newVal <= 10000 && !dp[newVal]) {
                    dp[newVal] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder("");
        for(int i=1; i<=10000; i++) {
            if(!dp[i]) {
                sb.append(i).append("\n");
            }
        }
        buf2.write(sb.toString());


        buf2.flush();
        buf.close();
        buf2.close();

    }
}
