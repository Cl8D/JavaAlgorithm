package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 한수
public class _1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        int answer = 99;

        if(n<100) {
            buf2.write(n + "");
        }
        else {
            for (int i = 100; i <= n; i++) {
                String str = String.valueOf(i);
                int minus = Character.getNumericValue(str.charAt(1)) - Character.getNumericValue(str.charAt(0));
                boolean flag = false;
                for (int j = 2; j < str.length(); j++) {
                    int temp = Character.getNumericValue(str.charAt(j)) - Character.getNumericValue(str.charAt(j-1));
                    if(minus != temp) {
                        flag = true;
                        break;
                    }
                }
                if(!flag)
                    answer++;
            }
            buf2.write(answer+"");
        }

        buf2.flush();
        buf.close();
        buf2.close();

    }
}
