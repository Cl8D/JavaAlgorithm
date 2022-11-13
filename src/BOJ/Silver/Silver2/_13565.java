package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 침투
public class _13565 {
    static int m, n;
    static char[][] val;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        stk = new StringTokenizer(buf.readLine());
        m = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());
        val = new char[m][n];

        // 0은 전류 통하는 흰색, 1은 전류가 안 통하는 검은색
        for (int i = 0; i < m; i++) {
            val[i] = buf.readLine().toCharArray();
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (val[i][j] == '1') {
                    continue;
                }
                if (i ==0 && val[i][j] == '0') {
                    dfs(i, j);
                }
            }
        }

        String answer = "NO";
        for (int i = 0; i < n; i++) {
            if (val[m-1][i] == '2') {
                answer = "YES";
                break;
            }
        }

        buf2.write(answer);
        buf2.flush();
        buf.close();
        buf2.close();
    }

    static void dfs(int x, int y) {
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }

            if (val[nx][ny] == '0') {
                val[nx][ny] = '2';
                dfs(nx, ny);
            }
        }
    }
}