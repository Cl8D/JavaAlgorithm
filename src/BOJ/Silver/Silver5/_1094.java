package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 막대기
public class _1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        int n = Integer.parseInt(buf.readLine());

        int count = 0;
        int stick = 64; // 초기의 값은 64cm


        while(n>0) {
            if (stick > n) {
                // 절반으로 자르기
                stick /= 2;
            }
            else {
                count++;
                n -= stick;
            }
        }
        buf2.write(count+"");
        buf2.flush();
        buf.close();
        buf2.close();
    }
}