package Inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10. 봉우리
public class _0210 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());
        int[][] grid = new int[n+2][n+2];

        for(int i=1; i<=n; i++) {
            StringTokenizer stk = new StringTokenizer(buf.readLine());
            for(int j=1; j<=n; j++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int count = 0;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                int now = grid[i][j];
                if ((now > grid[i-1][j]) && (now > grid[i+1][j]) && (now > grid[i][j-1]) && (now > grid[i][j+1]))
                    count++;
            }
        }

        System.out.println(count);

    }
}
