package BOJ.Silver.Silver2;

import java.io.*;
import java.util.StringTokenizer;

// 색종이 만들기
public class _2630 {
    static int n ,cnt1=0, cnt2=0;
    static int[][] val;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        n = Integer.parseInt(buf.readLine());
        val = new int[n][n];

        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            for(int j=0; j<n; j++) {
                val[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        recur(0, 0, n);

        // 0-> 흰색, 1-> 파란색
        System.out.println(cnt1);
        System.out.println(cnt2);

    }

    static void recur(int x, int y, int size) {
        if(check(x, y, size)) {
            if(val[x][y] == 0)
                cnt1++;
            else if(val[x][y] == 1)
                cnt2++;

            return;
        }

        int newSize = size / 2;
        recur(x, y, newSize);
        recur(x+newSize, y, newSize);
        recur(x, y+newSize, newSize);
        recur(x+newSize, y+newSize, newSize);

    }

    static boolean check(int x, int y, int size) {
        int start = val[x][y];
        for(int i=x; i<x+size; i++) {
            for(int j=y; j<y+size; j++) {
                if(start != val[i][j])
                    return false;
            }
        }
        return true;
    }

}