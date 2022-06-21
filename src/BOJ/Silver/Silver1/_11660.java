package BOJ.Silver.Silver1;

import java.io.*;
import java.util.StringTokenizer;

// 구간 합 구하기 5
public class _11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        // 적분영상 원리 생각하면 된다!
        // https://m.blog.naver.com/natalliea/222198638897

        int[][] val = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            stk = new StringTokenizer(buf.readLine());
            for(int j=1; j<=n; j++) {
                // 누적합
                if(i>1 && j>1)
                    val[i][j] = val[i - 1][j] + val[i][j - 1] - val[i - 1][j - 1] + Integer.parseInt(stk.nextToken());

                else if(i==1 && j==1)
                    val[i][j] = Integer.parseInt(stk.nextToken());

                else if(i==1)
                    val[i][j] = val[i][j - 1] + Integer.parseInt(stk.nextToken());

                else if(j==1)
                    val[i][j] = val[i - 1][j] + Integer.parseInt(stk.nextToken());
            }
        }


        for(int i=0; i<m; i++) {
            stk = new StringTokenizer(buf.readLine());
            int x1 = Integer.parseInt(stk.nextToken());
            int y1 = Integer.parseInt(stk.nextToken());
            int x2 = Integer.parseInt(stk.nextToken());
            int y2 = Integer.parseInt(stk.nextToken());

            buf2.write(val[x2][y2] + val[x1-1][y1-1] - val[x1-1][y2] - val[x2][y1-1] + "\n");
        }
        buf2.flush();
        buf.close();
        buf2.close();
    }
}