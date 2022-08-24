package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 부분수열의 합
public class _1182 {
    static int n, s, count=0;
    static int[] val, temp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(stk.nextToken());
        s = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(buf.readLine());
        val = new int[n];
        temp = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(stk.nextToken());
        }
        recur(0, 0);

        // s가 0일 때는 초기 sum이 0이어서 그 경우도 카운트되니깐 빼주기
        if(s == 0)
            count--;

        buf2.write(count + "");
        buf2.flush();
        buf.close();
        buf2.close();

    }

    static void recur(int idx, int sum) {
        if(idx == n) {
            if(sum==s)
                count++;
            return;
        }
        // 값을 더해주는 경우
        recur(idx+1, sum+val[idx]);
        // 안 더해주는 경우
        recur(idx+1, sum);

    }

}
