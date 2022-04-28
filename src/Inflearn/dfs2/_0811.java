package Inflearn.dfs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 11. 미로의 최단거리 통로 (BFS)
public class _0811 {
    static int[][] maze = new int[8][8];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        // 1은 벽, 0은 통로 => 0으로만 움직일 수 있음
        for(int i=1; i<=7; i++) {
            stk = new StringTokenizer(buf.readLine());
            for(int j=1; j<=7; j++) {
                maze[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        bfs(1, 1);

        if(maze[7][7] == 0)
            System.out.println(-1);
        else
            System.out.println(maze[7][7]);


    }

    static void bfs(int x, int y) {
        Queue<Coord> queue = new LinkedList<>();

        queue.add(new Coord(x, y));


        while(!queue.isEmpty()) {
            int nx=0, ny=0;
            Coord current = queue.poll();

            for(int i=0; i<4; i++) {
                nx = current.x + dx[i];
                ny = current.y + dy[i];

                if(nx >=1 && nx <=7 && ny >=1 && ny <=7) {
                    if(maze[nx][ny] == 0) {
                        // 이전까지의 최단 거리에서 +1 해주기
                        maze[nx][ny] = maze[current.x][current.y] + 1;
                        queue.add(new Coord(nx, ny));
                    }
                }
            }
        }

    }

    static class Coord{
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}