package BOJ.Gold.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 상범 빌딩
public class _6593 {
    static int l, r, c, answer;
    static Character[][][] building;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<Type> queue;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        while(true) {
            stk = new StringTokenizer(buf.readLine());
            // 빌딩의 층 수
            l = Integer.parseInt(stk.nextToken());
            // 한 층의 행의 수
            r = Integer.parseInt(stk.nextToken());
            // 한 층의 열의 수
            c = Integer.parseInt(stk.nextToken());

            if(l==0 && r==0 && c==0)
                break;

            // # 막힘 // . 비어있음 // S 시작 // E 출구
            answer = -1;
            building = new Character[l][r][c];
            visited = new boolean[l][r][c];
            queue = new LinkedList<>();

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    stk = new StringTokenizer(buf.readLine());
                    char[] chars = stk.nextToken().toCharArray();
                    for (int k = 0; k < c; k++) {
                        if(chars[k] == 'S') {
                            visited[i][j][k] = true;
                            building[i][j][k] = '.';
                            queue.add(new Type(j, k, i, 0));
                        }
                        else
                            building[i][j][k] = chars[k];
                    }
                }
                buf.readLine();
            }

            bfs();

            if(answer!=-1)
                System.out.println("Escaped in " + answer + " minute(s).");
            else
                System.out.println("Trapped!");

        }

    }

    static void bfs() {
        while(!queue.isEmpty()) {
            Type current = queue.poll();

            int nx=0, ny=0, nz=0;
            for (int i = 0; i < dx.length; i++) {
                nx = current.x + dx[i];
                ny = current.y + dy[i];
                nz = current.z + dz[i];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c && nz >= 0 && nz < l && !visited[nz][nx][ny]) {
                    visited[nz][nx][ny] = true;

                    if (building[nz][nx][ny] == '.') {
                        queue.add(new Type(nx, ny, nz, current.count + 1));
                        building[nz][nx][ny] = '#';
                    }

                    else if (building[nz][nx][ny] == 'E') {
                        answer = current.count + 1;
                        break;
                    }
                }
            }
        }

    }

    static class Type {
        int x;
        int y;
        int z;
        int count;

        public Type(int x, int y, int z, int count) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.count = count;
        }
    }
}