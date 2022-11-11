package BOJ.Silver.Silver1;

import java.io.*;
import java.util.*;

// 양
public class _3184 {

    static String[][] val;
    static int r, c, wolf=0, sheep=0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        // .은 필드, #은 울타리, o은 양, v는 늑대
        // 가로 세로만 이동 가능, 울타리는 이동 불가능
        // 이동한 구간이 곧 영역이 되고, 영역 안의 양의 수가 늑대보다 많으면 이김
        // 살아남은 늑대와 양의 수 구하기

        stk = new StringTokenizer(buf.readLine());
        r = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());
        val = new String[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            val[i] = buf.readLine().split("");
        }

        int ansSheep = 0, ansWolf = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (val[i][j].equals("#")) {
                    continue;
                }

                sheep = wolf = 0;
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j);
                }


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

    static void dfs(int x, int y) {
        // 영역 내의 양과 늑대의 수를 체크
        if (val[x][y].equals("o")) {
            sheep++;
        }
        if (val[x][y].equals("v")) {
            wolf++;
        }

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                continue;
            }

            if (val[nx][ny].equals("#")) {
                continue;
            }

            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }
}