package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 영화감독 숌
public class _1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        int first = 666;
        int count = 1;

        while(true) {
            if(count==n) {
                buf2.write(first+"");
                break;
            }
            first++;
            if(String.valueOf(first).contains("666")) {
                count++;
            }
        }


        buf2.flush();
        buf.close();
        buf2.close();

    }
}
