package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 돌 게임 2
public class _9656 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());

        if (n % 2== 1) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }

        buf2.flush();
        buf.close();
        buf2.close();

    }
}