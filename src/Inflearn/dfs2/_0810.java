package Inflearn.dfs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10. 미로 탐색(DFS)
public class _0810 {
    static int[][] maze = new int[8][8];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;

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

        // 시작지점 방문 처리 필수!
        maze[1][1] = 1;
        dfs(1, 1);
        System.out.println(answer);


    }

    static void dfs(int x, int y) {
        if(x==7 && y==7) {
            answer++;
        }
        else {
            int nx=0, ny=0;
            for(int i=0; i<4; i++) {
                nx = x+dx[i];
                ny = y+dy[i];

                if(nx >= 1 && nx <= 7 && ny >= 1 && ny <=7) {
                    if(maze[nx][ny] == 0) {
                        maze[nx][ny] = 1;
                        dfs(nx, ny);
                        maze[nx][ny] = 0;
                    }
                }
            }
        }
    }
}