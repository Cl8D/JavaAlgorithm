package Inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 9. 격자판 최대합
public class _0209 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());

        int[][] grid = new int[n][n];

        int result = 0;

        for(int i=0; i<n; i++) {
            StringTokenizer stk = new StringTokenizer(buf.readLine());
            // 행의 합 계산
            int row = 0;
            for(int j=0; j<n; j++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
                row += grid[i][j];
            }
            result = Math.max(result, row);
        }

        // 열의 합 계산
        for(int i=0; i<n; i++) {
            int col = 0;
            for(int j=0; j<n; j++) {
                col += grid[j][i];
            }
            result = Math.max(result, col);
        }

        // 대각선 합 계산
        // (0,0) (1,1) (2,2) (3,3) (4,4)
        // (0,4) (1,3) (2,2) (3,1) (4,0)
        int cross1 = 0;
        int cross2 = 0;
        for(int i=0; i<n; i++) {
            cross1 += grid[i][i];
            cross2 += grid[i][n-1-i];
        }
        result = Math.max(result, cross1);
        result = Math.max(result, cross2);

        System.out.println(result);

    }
}
