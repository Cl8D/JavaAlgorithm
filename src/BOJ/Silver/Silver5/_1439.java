package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 뒤집기
public class _1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        String str = buf.readLine();
        int answer = 0;

        char[] charArr = str.toCharArray();
        char init = charArr[0];
        int temp = 0;

        for(char c : charArr) {
            if(init != c) {
                temp++;
                continue;
            }
            if(temp > 0) {
                answer++;
                temp = 0;
            }
        }
        if(temp>0)
            answer++;

        buf2.write(answer+"");

        buf2.flush();
        buf.close();
        buf2.close();

    }
}
