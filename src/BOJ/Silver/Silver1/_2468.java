package BOJ.Silver.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 안전 영역
public class _2468 {
    static int n, maxVal=0;
    static int[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        n = Integer.parseInt(buf.readLine());

        board = new int[n][n];

        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(stk.nextToken());
                if(maxVal < board[i][j])
                    maxVal = board[i][j];
            }
        }

        int answer = 0;
        //  0부터 가장 큰 수(어차피 최대 100이니까 다 탐색)까지 하나씩 늘려가며 탐색해주기
        for(int i=0; i<maxVal+1; i++) {
            visited = new boolean[n][n];
            int cnt = 0;
            for(int p=0; p<n; p++) {
                for(int q=0; q<n; q++) {
                    // 높이를 넘으면서도 방문하지 않은 곳부터 탐색 시작
                    if(!visited[p][q] && board[p][q] > i) {
                        // dfs를 도는 것 = 하나의 영역을 다 돌게 되는 것이니까 영역 개수 +1
                        dfs(p, q, i);
                        cnt++;
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);

    }

    static void dfs(int x, int y, int height) {
        visited[x][y] = true;

        int nx = 0, ny =0;
        for(int i=0; i<dx.length; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if(nx>=0 && nx<n && ny>=0 && ny<n) {
                if(!visited[nx][ny] && board[nx][ny] > height) {
                    dfs(nx, ny, height);
                }
            }
        }
    }
}
