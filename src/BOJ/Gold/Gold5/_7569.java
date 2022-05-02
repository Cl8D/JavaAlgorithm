package BOJ.Gold.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토
public class _7569 {
    // (-1, 0, 0) (0, 1, 0) (1, 0, 0) (0, -1, 0) (0, 0, 1) (0, 0, -1)
    // 토마토 -> 왼쪽, 앞쪽, 오른쪽, 뒷쪽, 위쪽, 아래쪽
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static Queue<Point> queue = new LinkedList<>();
    static int[][][] tomato;
    static int[][][] distance;

    static int m, n, h;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());
        m = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());
        h = Integer.parseInt(stk.nextToken());

        tomato = new int[h][n][m];
        distance = new int[h][n][m];

        for(int i=0; i<h; i++) {
            for(int j=0; j<n; j++) {
                stk = new StringTokenizer(buf.readLine());
                for(int k=0; k<m; k++) {
                    tomato[i][j][k] = Integer.parseInt(stk.nextToken());
                }
            }
        }

        for(int i=0; i<h; i++) {
            for(int j=0; j<n; j++) {
                for(int k=0; k<m; k++) {
                    if(tomato[i][j][k] == 1) {
                        // bfs를 queue에 넣을 때마다 호출하는 게 아니라, queue에다가 미리!!! 1인 지점을 넣어둔 다음에,
                        // bfs 자체는 나중에 호출해야 한다 ㅠㅠ
                        // 왜냐면 익은 토마토들은 동시에! 6방향의 토마토들을 익히기 때문에
                        // 1인 위치를 미리 담아둬야 한다... ㅠ 이거 진짜 필수.
                        Point point = new Point(j, k, i);
                        queue.add(point);
                    }
                }
            }
        }

        bfs();

        for(int i=0; i<h; i++) {
            for(int j=0; j<n; j++) {
                for(int k=0; k<m; k++) {
                    if(tomato[i][j][k] == 0 && distance[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for(int i=0; i<h; i++) {
            for(int j=0; j<n; j++) {
                for(int k=0; k<m; k++) {
                    answer = Math.max(distance[i][j][k], answer);
                }
            }
        }
        if(answer == 0)
            System.out.println(0);
        else
            System.out.println(answer);
    }

    static void bfs() {
        while(!queue.isEmpty()) {
            Point current = queue.poll();
            int nx=0, ny=0, nz=0;

            for(int i=0; i<dx.length; i++) {
                nx = current.x + dx[i];
                ny = current.y + dy[i];
                nz = current.z + dz[i];


                if(nx >=0 && nx < n && ny >= 0 && ny < m && nz >= 0  && nz < h) {
                    if(tomato[nz][nx][ny] == -1)
                        continue;
                    if(tomato[nz][nx][ny] == 0) {
                        tomato[nz][nx][ny] = 1;
                        queue.add(new Point(nx, ny, nz));
                        distance[nz][nx][ny] = distance[current.z][current.x][current.y] + 1;
                    }
                }
            }
        }
    }

    static class Point {
        int x;
        int y;
        int z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}