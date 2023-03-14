package BOJ.Silver.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 음식물 피하기
public class _1743 {
    private static final Queue<Type> queue = new LinkedList<>();
    private static int answer = 0, n, m;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        map = new int[n+1][m+1];
        for (int i = 0; i < k; i++) {
            stk = new StringTokenizer(buf.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            map[x][y]= 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = 0;
                    queue.add(new Type(i, j));
                    bfs();
                }
            }
        }
        System.out.println(answer);
        buf.close();
    }

    static void bfs() {
        int count = 1;
        while(!queue.isEmpty()) {
            Type current = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx <= 0 || nx > n || ny <= 0 || ny > m || map[nx][ny] == 0) {
                    continue;
                }
                count++;
                map[nx][ny] = 0;
                queue.add(new Type(nx, ny));
            }
        }
        answer = Math.max(answer, count);
    }

    static class Type {
        int x;
        int y;

        public Type(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }
}
