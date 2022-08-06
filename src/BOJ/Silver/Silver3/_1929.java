package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// 소수 구하기
public class _1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        boolean[] val = new boolean[m+1];
        // 1은 소수가 아니니까...
        val[1] = true;

        // 에라토스테네스의 체
        for (int i = 2; i <=m; i++) {
            if(val[i])
                continue;
            // 배수 지우기
            for (int j = 2*i; j <=m; j+=i) {
                val[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder("");
        for (int i = n; i <= m; i++) {
            if(!val[i])
                sb.append(i).append("\n");
        }
        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();

    }
}
