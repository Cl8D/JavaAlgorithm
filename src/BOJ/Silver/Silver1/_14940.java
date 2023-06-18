package BOJ.Silver.Silver1;

import java.io.*;
import java.util.*;

// 쉬운 최단거리
public class _14940 {
    private static int[][] map, visited;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        stk = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        map = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(buf.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 못 가는 땅이 0 이면 그대로 0을, 1이면 -1을 출력해야 하니까 갈 수 있는 땅에 대해서만 초기화
                if (map[i][j] == 1) {
                    visited[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 2인 지점부터 시작하기
                if (map[i][j] == 2) {
                    visited[i][j] = 0;
                    bfs(i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(visited[i][j]).append(" ");
            }
            sb.append("\n");
        }
        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }

    private static void bfs(final int x, final int y) {
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(x, y));

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            final Info target = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = target.x + dx[i];
                int ny = target.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] != -1) {
                    continue;
                }
                if (map[nx][ny] == 0) {
                    visited[nx][ny] = 0;
                    continue;
                }

                visited[nx][ny] = visited[target.x][target.y] + 1;
                queue.add(new Info(nx, ny));
            }
        }
    }

    static class Info {
        int x;
        int y;

        public Info(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }
}
