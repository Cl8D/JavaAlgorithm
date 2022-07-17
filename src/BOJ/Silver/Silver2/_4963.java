package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 섬의 개수
public class _4963 {
    static int[][] val;
    static int w, h;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk;

        while(true) {
            stk = new StringTokenizer(buf.readLine());
            w = Integer.parseInt(stk.nextToken());
            h = Integer.parseInt(stk.nextToken());

            if(w==0 && h==0)   {
                break;
            }

            val = new int[h][w];
            for(int i=0; i<h; i++) {
                stk = new StringTokenizer(buf.readLine());
                for(int j=0; j<w; j++) {
                    val[i][j] = Integer.parseInt(stk.nextToken());
                }
            }

            int answer = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(val[i][j] == 1) {
                        val[i][j] = 0;
                        dfs(i, j);
                        answer++;
                    }
                }
            }
            buf2.write(answer+"\n");
        }

        buf2.flush();

        buf.close();
        buf2.close();

    }

    static void dfs(int x, int y) {
        for(int i=0; i<dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<h && ny>=0 && ny<w) {
                if(val[nx][ny] == 1) {
                    val[nx][ny] = 0;
                    dfs(nx, ny);
                }
            }
        }
    }

}
