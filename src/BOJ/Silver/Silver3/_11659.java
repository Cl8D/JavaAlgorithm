package BOJ.Silver.Silver3;

import java.io.*;
import java.util.StringTokenizer;

// 구간 합 구하기 4
public class _11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        // 수의 개수
        int n = Integer.parseInt(stk.nextToken());
        // 합을 구해야 하는 횟수
        int m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(buf.readLine());
        int[] val = new int[n+1];
        val[1] = Integer.parseInt(stk.nextToken());

        // 누적합 구해두기
        // 5 4 3 2 1
        // 합) 5 9 12 14 15
        for(int i=2; i<=n; i++) {
            val[i] = val[i-1] + Integer.parseInt(stk.nextToken());
        }

        for(int i=0; i<m; i++) {
            stk = new StringTokenizer(buf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            // 당연히 2중 for문으로 돌면 시간 초과 난다...!
            // b까지의 합 - (a-1)까지의 합이라는 점 이용하기
            buf2.write(val[b]-val[a-1]+"\n");
        }

        buf2.flush();
        buf.close();
        buf2.close();

    }
}