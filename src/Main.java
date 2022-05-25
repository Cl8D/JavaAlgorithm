import java.io.*;
import java.util.*;

public class Main {
    static int n, m, answer = 0;
    static char[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Type> redQueue;
    static Queue<Type> blueQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        board = new char[n][m];
        redQueue = new LinkedList<>();
        blueQueue = new LinkedList<>();

        for(int i=0; i<n; i++) {
            board[i] = buf.readLine().toCharArray();
            for(int j=0; j<m; j++) {
                if(board[i][j] == 'R') {
                    redQueue.add(new Type(i, j, 0));
                    board[i][j] = '.';
                }
                else if(board[i][j] == 'B') {
                    blueQueue.add(new Type(i, j, 0));
                    board[i][j] = '.';
                }
            }
        }

        bfs();
        if(answer == 0)
            System.out.println(-1);
        else
            System.out.println(answer);

    }

    static void bfs() {
        while(!redQueue.isEmpty()) {
            Type curRed = redQueue.poll();
            Type curBlue = blueQueue.poll();

            if (curRed.count <= 10) {
                for (int i = 0; i < dx.length; i++) {
                    int[] red = {curRed.x, curRed.y};
                    int[] blue = {curBlue.x, curBlue.y};

                    // 각 동작으로 구슬 굴리기
                    move(red, dx[i], dy[i]);
                    move(blue, dx[i], dy[i]);

                    // 구슬 위치 체크
                    // 둘 다 구멍으로 들어갔거나, 파란색만 들어간 경우 실패
                    if (board[blue[0]][blue[1]] == 'O')
                        continue;

                    // 빨간 구슬만 들어간 경우 성공
                    if (board[red[0]][red[1]] == 'O' && board[blue[0]][blue[1]] != 'O') {
                        answer = curRed.count;
                        return;
                    }

                    // 둘 다 안 들어갔을 경우
                    else {
                        // 두 개의 구슬이 같은 위치에 있는지 판단하기
                        if(red[0] == blue[0] && red[1] == blue[1]) {
                            // 두 구슬 중에서 더 이전의 위치에 있던 애를 기준으로 이동시켜주기.
                            if(i==0) { // 위쪽
                                if(curRed.x < curBlue.x) // 빨간색이 더 위에 있었으면 파란색을 이전의 위치로 이동시키기
                                    blue[0] += 1;
                                else
                                    red[0] += 1;
                            }
                            else if(i==1) { // 아래
                                if(curRed.x > curBlue.x)  // 빨간색이 더 아래 > 파란색을 이전으로
                                    blue[0] -= 1;
                                else
                                    red[0] -= 1;
                            }
                            else if(i==3) {// 오른쪽
                                if (curRed.y > curBlue.y) // 빨간색이 더 오른쪽
                                    blue[1] -= 1;
                                else
                                    red[1] -= 1;
                            }
                            else {
                                if(curRed.y < curBlue.y)
                                    blue[1] += 1;
                                else
                                    red[1] += 1;
                            }
                        }
                    }

                    redQueue.add(new Type(red[0], red[1], curRed.count+1));
                    blueQueue.add(new Type(blue[0], blue[1], curBlue.count+1));
                }
            }
        }

    }

    static void move(int[] color, int dx, int dy) {
        while(true) {
            int nx = color[0] + dx;
            int ny = color[1] + dy;

            if (nx >= 0 && nx < n && ny >=0 && ny <m) {
                // 벽인 경우
                if(board[nx][ny] == '#')
                    break;

                // 벽이 아니니까 우선 이동
                color[0] = nx;
                color[1] = ny;

                // 구멍인 경우 그만 이동하기
                if (board[nx][ny] == 'O')
                    break;
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