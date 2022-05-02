package BOJ.Silver.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 유기농 배추
public class _1012 {
    static int n;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int t = Integer.parseInt(buf.readLine());

        for(int i=0; i<t; i++) {
            stk = new StringTokenizer(buf.readLine());
            // 배추밭의 가로 길이
            int m = Integer.parseInt(stk.nextToken());
            // 배추밭의 세로 길이
            int n = Integer.parseInt(stk.nextToken());
            // 배추가 심어져 있는 위치 개수
            int k = Integer.parseInt(stk.nextToken());

            int[][] cabbage = new int[n][m];

            for(int j=0; j<k; j++){
                stk = new StringTokenizer(buf.readLine());
                int y = Integer.parseInt(stk.nextToken());
                int x = Integer.parseInt(stk.nextToken());
                cabbage[x][y] = 1;
            }

            int answer = 0;

            for(int j=0; j<n; j++) {
                for(int p=0; p<m; p++) {
                    if(cabbage[j][p] == 1) {
                        Point point = new Point(j, p);
                        bfs(m, n, point, cabbage);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    static void bfs(int m, int n, Point p, int[][] cabbage) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(p);

        while(!queue.isEmpty()) {
            Point current = queue.poll();
            int nx=0, ny=0;
            for(int i=0; i<dx.length; i++) {
                nx = current.x + dx[i];
                ny = current.y + dy[i];

                if(nx>=0 && nx <n && ny >=0 && ny < m) {
                    if(cabbage[nx][ny] == 1) {
                        cabbage[nx][ny] = 0;
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