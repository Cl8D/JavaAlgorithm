package BOJ.Gold.Gold5;

import java.io.*;
import java.util.*;

// 연구소
public class _14502 {
    static int n, m, answer = 0;
    static int[][] val;
    static Queue<Type> queue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        val = new int[n][m];


        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            for(int j=0; j<m; j++) {
                int v = Integer.parseInt(stk.nextToken());
                val[i][j] = v;
            }
        }

        // 임의의 세 곳에 벽 세우기 시작
        makeWall(0);

        buf2.write(answer+"");
        buf2.flush();
        buf.close();
        buf2.close();
    }

    static void makeWall(int count) {
        // 벽의 개수가 3개라면
        if(count == 3) {
            // 바이러스 확산 후 빈칸의 개수 파악하기
            bfs();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 만약 빈칸이라면
                if(val[i][j] == 0) {
                    // 벽을 세우고 다시 허무는 과정 진행
                    val[i][j] = 1;
                    makeWall(count+1);
                    val[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        queue = new LinkedList<>();
        // 바이러스가 전파된 맵
        int[][] virus = clone(val);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(virus[i][j] == 2)
                    queue.add(new Type(i, j));
            }
        }

        while(!queue.isEmpty()) {
            Type current = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (virus[nx][ny] == 0) {
                        virus[nx][ny] = 2;
                        queue.add(new Type(nx, ny));
                    }
                }
            }
        }
        answer = Math.max(answer, compute(virus));
    }

    static int[][] clone(int[][] arr) {
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = arr[i][j];
            }
        }
        return result;
    }

    static int compute(int[][] arr) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 0)
                    ans++;
            }
        }
        return ans;
    }

    static class Type {
        int x;
        int y;

        public Type(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
