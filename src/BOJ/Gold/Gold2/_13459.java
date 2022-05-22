package BOJ.Gold.Gold2;

import java.io.*;
import java.util.*;

public class _13459 {
    static int n, m, answer=0;
    static char[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        board = new char[n][m];
        int rx=0, ry=0, bx=0, by=0;
        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            board[i] = stk.nextToken().toCharArray();
            for(int j=0; j<m; j++) {
                if(board[i][j]=='R') {
                    rx = i;
                    ry = j;
                    board[i][j] = '.';
                }
                else if(board[i][j] =='B') {
                    bx = i;
                    by = j;
                    board[i][j] = '.';
                }
            }
        }

        // 둘은 같이 이동하니까!
        dfs(0, rx, ry, bx, by);
        System.out.println(answer);

    }

    // 경우의 수가 10가지, 4^10 정도니까 모든 경우의 수를 탐색하는 방향으로 진행하기
    // 참고) https://moons-memo.tistory.com/236
    static void dfs(int depth, int rx, int ry, int bx, int by) {
        if(answer == 1)
            return;
        // depth = 구슬이 굴러간 횟수
        if(depth == 10)
            return;

        for(int i=0; i<dx.length; i++) {
            int red[] = {rx, ry};
            int blue[] = {bx, by};
            move(red, dx[i], dy[i]);
            move(blue, dx[i], dy[i]);

            int type = check(red, blue); // 각각의 경우의 수에 대해 체크

            // 0이면 실패 -> 다음 경우 탐색
            if (type == 0) {
                continue;
            }
            // 1이면 성공 -> 함수 종료 후 리턴
            else if (type == 1) {
                answer = 1;
                return;
            }
            //2면 계속 탐색
            else {
                // 둘 다 구멍은 아니지만, 같은 위치에 있는 경우를 동서남북으로 탐색
                // 이전에 더 (동/서/남/북)에 있던 애를 두고, 다른 애를 해당 방향으로 +1 해주기
                if(red[0] == blue[0] && red[1] == blue[1]) {
                    if(i==0) { // 위
                        if(rx < bx) // 이전 위치는 빨간색이 더 위에 있었음
                            blue[0] += 1; // 파란색의 위치를 +1
                        else
                            red[0] += 1;
                    }
                    else if(i==2) { // 아래
                        if(rx > bx)
                            blue[0] -=1;
                        else
                            red[0] -=1;
                    }
                    else if(i==1) { // 오른쪽
                        if(ry > by)
                            blue[1] -= 1;
                        else
                            red[1] -= 1;
                    }
                    else { // 왼쪽
                        if(ry < by)
                            blue[1] += 1;
                        else
                            red[1] += 1;
                    }
                }
            }

            dfs(depth+1, red[0], red[1], blue[0], blue[1]);
        }

    }

    static void move(int[] color, int dx, int dy) {
        int nx = color[0];
        int ny = color[1];

        while(true) {
            nx += dx;
            ny += dy;

            // 벽이면 다시 뒤로 가기
            if (board[nx][ny] == '#') {
                nx -= dx;
                ny -= dy;
                break;
            }

            // 구명이면 종료
            else if (board[nx][ny] == 'O')
                break;

        }

        color[0] = nx;
        color[1] = ny;
    }

    static int check(int red[], int blue[]) {
        int rx = red[0];
        int ry = red[1];
        int bx = blue[0];
        int by = blue[1];

        // 둘다 구멍으로 감 (X)
        if(board[rx][ry] == 'O' && board[bx][by] == 'O')
            return 0;

        // 빨간색만 구멍으로 감 (정답)
        if(board[rx][ry] == 'O' && board[bx][by] != 'O')
            return 1;

        // 파란색만 구멍으로 감 (X)
        if(board[rx][ry] != 'O' && board[bx][by] == 'O')
            return 0;

        // 둘 다 구멍으로 안 감 (이동중)
        if(board[rx][ry] != 'O' && board[bx][by] != 'O')
            return 2;

        return 0; // default
    }



}



/***********************/

// 잘못된 코드......ㅎ;
//import java.io.*;
//import java.util.*;
//
//public class Main {
//    static int n, m, answer=0, count=0;
//    static char[][] board;
//    static int[] dx = {0, 0, 1, -1};
//    static int[] dy = {1, -1, 0, 0};
//    static Queue<Type> redQueue;
//    static Queue<Type> blueQueue;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer stk;
//        stk = new StringTokenizer(buf.readLine());
//
//        n = Integer.parseInt(stk.nextToken());
//        m = Integer.parseInt(stk.nextToken());
//
//        board = new char[n][m];
//        redQueue = new LinkedList<>();
//        blueQueue = new LinkedList<>();
//
//        for(int i=0; i<n; i++) {
//            stk = new StringTokenizer(buf.readLine());
//            board[i] = stk.nextToken().toCharArray();
//            for(int j=0; j<m; j++) {
//                if(board[i][j]=='R') {
//                    redQueue.add(new Type(i, j));
//                    board[i][j] = '.';
//                }
//                else if(board[i][j] =='B') {
//                    blueQueue.add(new Type(i, j));
//                    board[i][j] = '.';
//                }
//            }
//        }
//
//        bfs();
//        System.out.println(answer);
//
//    }
//
//    // https://kkoon9.tistory.com/89
//    // 이거 참고해서 하고 있었는데 답이 안 나오넹...ㅠ
//
//    static void bfs() {
//        while(!redQueue.isEmpty() && count<10) {
//            count++;
//            for(int i=0; i< redQueue.size(); i++) {
//                Type curRed = redQueue.poll();
//                Type curBlue = blueQueue.poll();
//
//                Type moveRed = null;
//                Type moveBlue = null;
//
//                for (int j = 0; j < dx.length; j++) {
//                    moveRed = move(curRed.x, curRed.y, dx[j], dy[j]);
//                    moveBlue = move(curBlue.x, curBlue.y, dx[j], dy[j]);
//
//                    if (board[moveRed.x][moveRed.y] == 'O' && board[moveBlue.x][moveBlue.y] != 'O') {
//                        answer = 1;
//                        return;
//                    }
//                    else if (board[moveRed.x][moveRed.y] != 'O' && board[moveBlue.x][moveBlue.y] == 'O') {
//                        continue;
//                    }
//                    else if (board[moveRed.x][moveRed.y] == 'O' && board[moveBlue.x][moveBlue.y] == 'O') {
//                        continue;
//                    }
//                    else {
//                        if(moveRed.x == moveBlue.x && moveRed.y == moveBlue.y) {
//                            if(i==0) {
//                                if(curRed.y > curBlue.y)
//                                    moveBlue.y -= 1;
//                                else
//                                    moveRed.y -= 1;
//                            }
//                            else if(i==1) {
//                                if(curRed.y < curBlue.y)
//                                    moveBlue.y += 1;
//                                else
//                                    moveRed.y += 1;
//                            }
//                            else if(i==2) {
//                                if(curRed.x > curBlue.x)
//                                    moveBlue.x -=1;
//                                else
//                                    moveRed.x -=1;
//                            }
//                            else {
//                                if(curRed.x < curBlue.x)
//                                    moveBlue.x += 1;
//                                else
//                                    moveRed.x += 1;
//                            }
//                        }
//                    }
//                }
//                redQueue.add(moveRed);
//                blueQueue.add(moveBlue);
//            }
//
//        }
//
//    }
//
//    static Type move(int x, int y, int dx, int dy) {
//        Type cur = null;
//        int nx=0, ny=0;
//        while(true) {
//            nx = x + dx;
//            ny = y + dy;
//
//            if(nx>=0 && nx<n && ny>=0 && ny<m) {
//                // 벽이면 이전 위치로
//                if (board[nx][ny] == '#') {
//                    cur = new Type(x, y);
//                    break;
//                }
//                // 구멍이면 이동
//                else if (board[nx][ny] == 'O') {
//                    cur = new Type(nx, ny);
//                    break;
//                }
//                x=nx;
//                y=ny;
//            }
//        }
//        return cur;
//    }
//
//    static class Type {
//        int x;
//        int y;
//
//        public Type(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//}
//
//
