package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 행렬 곱셈
public class _2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[][] matrixA = new int[n][m];

        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            for(int j=0; j<m; j++) {
                int val = Integer.parseInt(stk.nextToken());
                matrixA[i][j] = val;
            }
        }

        stk = new StringTokenizer(buf.readLine());
        m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[][] matrixB = new int[m][k];

        for(int i=0; i<m; i++) {
            stk = new StringTokenizer(buf.readLine());
            for(int j=0; j<k; j++) {
                int val = Integer.parseInt(stk.nextToken());
                matrixB[i][j] = val;
            }
        }

        int[][] answer = new int[n][k];
        for(int i=0; i<n; i++) {
            for(int j=0; j<k; j++) {
                for(int p=0; p<m; p++) {
                    answer[i][j] += matrixA[i][p] * matrixB[p][j];
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<k; j++) {
                buf2.write(answer[i][j] + " ");
            }
            buf2.write("\n");
        }

        buf2.flush();
        buf.close();
        buf2.close();

    }
}
