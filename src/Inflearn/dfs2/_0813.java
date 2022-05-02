package Inflearn.dfs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 13. 섬나라 아일랜드 (DFS)
public class _0813 {
    static int n;
    static int[][] island;
    // 상하좌우 대각선
    // (-1 0) (1 0) (0 1) (0 -1) (1 1) (-1 -1) (1 -1) (-1 1)
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
                    // 출발하는 지점에 대해 방문처리!! 필수...!
                    island[i][j] = 0;
                    dfs(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }

    static void dfs(int x, int y) {
        int nx=0, ny=0;
        for(int i=0; i<dx.length; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if(nx >=0 && nx <n && ny >=0 && ny <n) {
                if(island[nx][ny] == 1) {
                    island[nx][ny] = 0;
                    dfs(nx, ny);
                }
            }
        }
    }
}