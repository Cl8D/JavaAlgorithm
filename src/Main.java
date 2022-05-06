import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int r, c;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());
        // 세로 R칸, 가로 C칸.
        // 알파벳 대문자가 하나씩, (1,1)에는 말.
        // 말은 상하좌우로 이동 가능 -> 이때 새로 이동한 칸의 알파벳은 지나왔던 알파벳들과 달라야 함.

        // 말이 최대한 몇 칸을 갈 수 있는지, 시작점 포함!

        r = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());
        board = new char[r][c];

        for(int i=0; i<r; i++) {
            String value = buf.readLine();
            for(int j=0; j<c; j++) {
                board[i][j] = value.charAt(j);
            }
        }

    }

    static void dfs(int x, int y) {
        int nx=0, ny =0;
        for(int i=0; i<dx.length; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if(nx>=0 && nx<)
        }
    }
}