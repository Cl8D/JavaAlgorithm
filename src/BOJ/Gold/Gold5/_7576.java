package BOJ.Gold.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토
public class _7576 {
    static int n, m;
    static int[][] tomato, distance;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());
        m = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());

        tomato = new int[n][m];
        // 토마토가 익는데 걸리는 시간
        distance = new int[n][m];

        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            for(int j=0; j<m; j++) {
                tomato[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                // 익은 토마토(1)이 퍼져나갈 수 있는 지점
                // 이게 다 출발점이 되는 것이고, 이럴 때는 큐에 먼저 넣어놔야 한다!
                if(tomato[i][j] == 1) {
                    Point point = new Point(i, j);
                    queue.add(point);
                }
            }
        }
        bfs();

        // 안 익은 토마토가 존재함 = 0이 아직 존재하는 것
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(tomato[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        int answer = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                answer = Math.max(answer, distance[i][j]);
            }
        }

        System.out.println(answer);


    }

    static void bfs() {
        while(!queue.isEmpty()) {
            Point current = queue.poll();
            int nx=0, ny= 0;

            for(int i=0; i<dx.length; i++) {
                nx = current.x + dx[i];
                ny = current.y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(tomato[nx][ny] == -1)
                        continue;
                    if(tomato[nx][ny] == 0) {
                        tomato[nx][ny] = 1;
                        queue.add(new Point(nx, ny));
                        distance[nx][ny] = distance[current.x][current.y]+1;
                    }
                }
            }

        }

    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
