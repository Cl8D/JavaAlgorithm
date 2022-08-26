package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// k번째 수
public class _11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(buf.readLine());
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(val);
        buf2.write(val[k-1] + "");

        buf2.flush();
        buf.close();
        buf2.close();

    }
}
