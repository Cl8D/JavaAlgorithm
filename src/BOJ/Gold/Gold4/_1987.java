package BOJ.Gold.Gold4;

import java.util.*;
import java.io.*;

// 1987 알파벳
public class _1987 {
    static char[][] val;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int r, c;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(buf.readLine());

        r = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());
        val = new char[r][c];

        for(int i=0; i<r; i++) {
            char[] value = new char[c];
            value = buf.readLine().toCharArray();
            for(int j=0; j<c; j++) {
                val[i][j] = value[j];
            }
        }

        visited = new boolean[26]; // 알파벳 개수
        int idx = val[0][0] - 'A';
        visited[idx] = true;
        dfs(0, 0, 1);
        System.out.println(answer);



    }
    static void dfs(int x, int y, int length) {
        // 결국 깊이가 최대가 되는 지점 구하는 것과 동일
        answer = Math.max(answer, length);

        int nx=0, ny=0;
        for(int i=0; i<dx.length; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if(nx>=0 && nx<r && ny >=0 && ny< c) {
                // char형을 int형으로 변경
                int idx = val[nx][ny] - 'A';
                if(!visited[idx]) {
                    visited[idx] = true;
                    dfs(nx, ny, length+1);
                    visited[idx] = false;
                }

            }
        }
    }
}
