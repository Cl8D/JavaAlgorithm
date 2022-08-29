package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 에라토스테네스의 체
public class _2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        boolean[] visited = new boolean[n+1];

        int temp = 0;
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j+=i) {
                if(!visited[j]) {
                    temp++;
                    if(temp == k) {
                        answer = j;
                        break;
                    }
                    visited[j] = true;
                }
            }
        }
        buf2.write(answer+"");
        buf2.flush();
        buf.close();
        buf2.close();

    }
}
