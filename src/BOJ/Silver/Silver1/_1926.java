package BOJ.Silver.Silver1;

import java.io.*;
import java.util.*;

// 그림
public class _1926 {
    static int n, m, tempWidth=0;
    static int[][] val;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        stk = new StringTokenizer(buf.readLine());

        // 도화지의 세로 크기, 가로 크기
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        val = new int[n][m];

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(buf.readLine());
            for (int j = 0; j < m; j++) {
                // 0은 색칠이 안 된 부분, 1은 색칠이 된 부분
                val[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        // 그림의 개수
        int count = 0;

        // 가장 넓은 그림의 넓이
        int width = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (val[i][j] == 1) {
                    val[i][j] = 0;
                    queue.add(new Point(i, j));
                    bfs();
                    width = Math.max(width, tempWidth);
                    tempWidth = 0;
                    count++;
                }
            }
        }

        sb.append(count).append("\n").append(width);

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }

    static void bfs () {
        while(!queue.isEmpty()) {
            Point current = queue.poll();
            tempWidth++;

            for (int i = 0; i < dx.length; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (val[nx][ny] == 1) {
                    val[nx][ny] = 0;
                    queue.add(new Point(nx, ny));
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