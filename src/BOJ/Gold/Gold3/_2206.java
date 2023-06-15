package BOJ.Gold.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽 부수고 이동하기
// 아이디어가 중요한 문제인 것 같다 ;ㅅ;
public class _2206 {

    private static int[][] map;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            final String[] row = buf.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }

        int result = bfs();
        System.out.println(result);
        buf.close();
    }

    private static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1, false));
        boolean[][][] visited = new boolean[n][m][2];

        // 처음에 벽을 부술 수 있는 모든 경우의 수를 탐색하려고 했는데 이러면 당연 시간초과가 난다... visited 배열로부터 힌트를 얻는 방향도 좋다.
        // 0 -> 벽을 부순 적 없이 탐색한 경우
        // 1 -> 벽을 부수고 탐색한 경우
        // 두 경우 모두 고려를 해줘야 함.
        visited[0][0][0] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            final Point current = queue.poll();

            if (current.x == n - 1 && current.y == m - 1) {
                return current.distance;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                // 다음 위치가 갈 수 있음
                if (map[nx][ny] == 0) {
                    // 벽을 부순 적 없고 방문한 적 없음
                    if (!current.isBroken && !visited[nx][ny][0]) {
                        // 부술 필요 없으니까 그대로 false
                        queue.add(new Point(nx, ny, current.distance + 1, false));
                        visited[nx][ny][0] = true; // 방문 처리
                        continue;
                    }
                    // 벽을 부순 적 있으면서 방문한 적 없음
                    if (current.isBroken && !visited[nx][ny][1]) {
                        queue.add(new Point(nx, ny, current.distance + 1, true));
                        visited[nx][ny][1] = true; // 방문 처리
                    }
                } else {
                    // 다음 위치가 벽임
                    // 부술 수 있으면 부수고 가기
                    if (!current.isBroken) {
                        queue.add(new Point(nx, ny, current.distance + 1, true));
                        visited[nx][ny][1] = true; // 방문 처리
                    }
                }
            }
        }
        return -1;
    }

    static class Point {

        int x;
        int y;
        int distance;
        boolean isBroken;

        public Point(final int x, final int y, final int distance, final boolean isBroken) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.isBroken = isBroken;
        }
    }
}
