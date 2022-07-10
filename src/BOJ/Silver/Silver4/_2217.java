package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 로프
public class _2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        Integer[] val = new Integer[n];
        for(int i=0; i<n; i++)
            val[i] = Integer.parseInt(buf.readLine());

        Arrays.sort(val, Collections.reverseOrder());

        int answer = 0;
        for(int i=0; i<n; i++)
            answer = Math.max(answer, val[i] * (i+1));

        buf2.write(answer+"");

        buf2.flush();
        buf.close();
        buf2.close();

    }
}
