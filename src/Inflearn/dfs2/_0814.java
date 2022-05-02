package Inflearn.dfs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 14. 섬나라 아일랜드 (BFS)
public class _0814 {
    static int n;
    static int[][] island;
    static int[] dx = {-1, 1, 0, 0, 1, -1, 1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        n = Integer.parseInt(buf.readLine());

        island = new int[n][n];

        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            for(int j=0; j<n; j++) {
                island[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        int answer = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(island[i][j] == 1) {
                    Point point = new Point(i, j);
                    bfs(point);
                    answer++;
                }
            }
        }
        System.out.println(answer);

    }

    static void bfs(Point p) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(p);

        while(!queue.isEmpty()) {
            Point current = queue.poll();
            int nx=0, ny=0;
            for(int i=0; i<dx.length; i++) {
                nx = current.x + dx[i];
                ny = current.y + dy[i];

                if(nx>=0 && nx <n && ny>=0 && ny < n) {
                    if(island[nx][ny] == 1) {
                        island[nx][ny] = 0;
                        queue.add(new Point(nx, ny));
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