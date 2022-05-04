package BOJ.Silver.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 영역 구하기
public class _2583 {
    static int[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int m, n;
    static List<Integer> area;
    static int dimension;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        // mxn 크기
        m = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        board = new int[m][n];

        // 왼쪽 아래 - 오른쪽 위의 (x, y) 좌표값
        for(int i=0; i<k; i++) {
            stk = new StringTokenizer(buf.readLine());

            int x1 = Integer.parseInt(stk.nextToken());
            int y1 = Integer.parseInt(stk.nextToken());

            int x2 = Integer.parseInt(stk.nextToken());
            int y2 = Integer.parseInt(stk.nextToken());

            for(int p=x1; p<x2; p++) {
                for(int q=y1; q<y2; q++) {
                    // 직사각형 영역에 대해 미리 1로 초기화해주기
                    board[q][p] = 1;
                }
            }
        }

        area = new ArrayList<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                // 0이라면 DFS를 돌면서 1인 영역 탐지하기
                if(board[i][j] == 0) {
                    dimension = 0;
                    // 첫 스타트 지점 방문처리 진행
                    board[i][j] = 1;
                    dfs(i, j);
                    area.add(dimension);
                }
            }
        }
        // 영역의 수
        System.out.println(area.size());

        Collections.sort(area);

        // 각 영역의 넓이
        for(int a : area) {
            System.out.print(a + " ");
        }
    }

    static void dfs(int x, int y) {
        // 한칸이 넓이=1이 되는 것!
        dimension++;

        for(int i=0; i<dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx < m && ny>=0 && ny < n) {
                if(board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    dfs(nx, ny);
                }
            }
        }
    }
}
