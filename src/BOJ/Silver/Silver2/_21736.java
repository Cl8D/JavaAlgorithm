package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 헌내기는 친구가 필요해
public class _21736 {
    private static String[][] map;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int n, m, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        map = new String[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = buf.readLine().split("");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j].equals("I")) {
                    search(i, j);
                }
            }
        }

        if (answer == 0) {
            System.out.println("TT");
        } else {
            System.out.println(answer);
        }

        buf.close();
    }

    private static void search(final int x, final int y) {
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny].equals("X")) {
                continue;
            }

            if (map[nx][ny].equals("P")) {
                answer++;
            }

            map[nx][ny] = "X";
            search(nx, ny);
        }
    }
}
