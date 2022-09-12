package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 숫자판 점프
public class _2210 {
    static int[][] val = new int[5][5];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited = new boolean[5][5];
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < 5; i++) {
            stk = new StringTokenizer(buf.readLine());
            for (int j = 0; j < 5; j++) {
                val[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, "");
            }
        }

        buf2.write(set.size()+"");
        buf2.flush();
        buf.close();
        buf2.close();
    }

    static void dfs(int x, int y, String str) {
        if(str.length() == 6) {
            set.add(str);
            return;
        }
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                dfs(nx, ny, str + val[nx][ny]);
            }
        }
    }
}