package BOJ.Silver.Silver1;

import java.io.*;
import java.util.*;

// 양치기 꿍
public class _3187 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] val;
    static boolean[][] visited;
    static int r, c;
    static int wolf = 0, sheep = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        stk = new StringTokenizer(buf.readLine());
        r = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());

        val = new char[r][c];
        visited = new boolean[r][c];

        // 양이 더 많으면 늑대가 잡아먹힘 (그게 아니면 양이 먹힘)
        // v 늑대 k 양
        for (int i = 0; i < r; i++) {
            val[i] = buf.readLine().toCharArray();
        }

        int ansWolf = 0, ansSheep = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (val[i][j] == '#') {
                    continue;
                }
                wolf = sheep = 0;
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j);
                }
                // 양이 더 많으면 늑대 죽음
                if (sheep > wolf) {
                    ansSheep += sheep;
                } else {
                    ansWolf += wolf;
                }
            }
        }

        buf2.write(ansSheep + " " + ansWolf);
        buf2.flush();
        buf.close();
        buf2.close();
    }

    static void dfs (int x, int y) {
        if (val[x][y] == 'v') {
            wolf++;
        }
        if (val[x][y] == 'k') {
            sheep++;
        }

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                continue;
            }

            if (val[nx][ny] == '#') {
                continue;
            }

            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }
}
