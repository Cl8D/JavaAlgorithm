package BOJ.Silver.Silver1;

import java.io.*;
import java.util.*;

// 나이트의 이동
public class _7562 {
    static int l, currentX, currentY, moveX, moveY;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static Queue<Type> queue;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int t = Integer.parseInt(buf.readLine());
        for(int i=0; i<t; i++) {
            l = Integer.parseInt(buf.readLine());
            map = new int[l][l];

            stk = new StringTokenizer(buf.readLine());
            currentX = Integer.parseInt(stk.nextToken());
            currentY = Integer.parseInt(stk.nextToken());
            map[currentX][currentY] = 1;

            stk = new StringTokenizer(buf.readLine());
            moveX = Integer.parseInt(stk.nextToken());
            moveY = Integer.parseInt(stk.nextToken());

            queue = new LinkedList<>();
            queue.add(new Type(currentX, currentY, 0));
            bfs();
        }
        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();

    }

    static void bfs() {
        while(!queue.isEmpty()) {
            Type current = queue.poll();

            if(current.x == moveX && current.y == moveY) {
                sb.append(current.count).append("\n");
                break;
            }

            for(int i=0; i<dx.length; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx>=0 && nx <l && ny>=0 && ny<l) {
                    if(map[nx][ny] == 0) {
                        map[nx][ny] = 1;
                        queue.add(new Type(nx, ny, current.count+1));
                    }
                }
            }
        }
    }
    static class Type {
        int x;
        int y;
        int count;

        public Type(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
