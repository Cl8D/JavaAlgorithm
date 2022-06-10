package BOJ.Gold.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 적록색약
public class _10026 {
    static int n;
    static char[][] val;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        n = Integer.parseInt(buf.readLine());
        val = new char[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++) {
            val[i] = buf.readLine().toCharArray();
        }


        int count = 0;
        int count2 = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j, 0);
                    count++;
                }
            }
        }

        visited = new boolean[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j, 1);
                    count2++;
                }
            }
        }

        System.out.println(count + " " + count2);

    }

    static void dfs(int x, int y, int type) {
        int nx = 0, ny = 0;
        for(int i=0; i<dx.length; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if(nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny]) {
                if(type == 0) {
                    if (val[x][y] == val[nx][ny]) {
                        visited[nx][ny] = true;
                        dfs(nx, ny, 0);
                    }
                }
                else {
                    if((val[x][y] == 'R' && (val[nx][ny] == 'R' || val[nx][ny] == 'G')) ||
                            (val[x][y] == 'B' && val[nx][ny] == 'B') ||
                            (val[x][y] == 'G' && (val[nx][ny] == 'G' || val[nx][ny] == 'R') )) {
                        visited[nx][ny] = true;
                        dfs(nx, ny, 1);
                    }
                }
            }
        }
    }
}
