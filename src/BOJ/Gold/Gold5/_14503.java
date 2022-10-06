package BOJ.Gold.Gold5;

import java.io.*;
import java.util.*;

// 로봇 청소기
public class _14503 {

    static int n, m, answer = 0;

    static int[][] val;

    // 북동남서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        stk = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(buf.readLine());
        // 로봇 청소기의 좌표
        int r = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());
        int d = Integer.parseInt(stk.nextToken());

        val = new int[n][m];

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(buf.readLine());
            for (int j = 0; j < m; j++) {
                val[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        simul(r, c, d);
        System.out.println(answer);

        buf2.flush();
        buf.close();
        buf2.close();
    }

    static void simul (int x, int y, int d) {
        // 현재 위치 청소하기
        if (val[x][y] == 0) {
            val[x][y] = 2;
            answer++;
        }

        boolean flag = false;
        int origin = d;
        for (int i = 0; i < 4; i++) {
            // 시뮬레이션 문제에서 많이 나오는 패턴인 것 같다... 이거는 외워놔도 될 듯
            // 왼쪽 방향으로 변환하기: 북->서->남->동
            int nd = (d + 3) % 4;
            int nx = x + dx[nd];
            int ny = y + dy[nd];

            // 범위 내의 값인지 체크
            if(nx>=0 && nx<n && ny>=0 && ny<m) {
                // 청소하지 않았을 경우
                if (val[nx][ny] == 0) {
                    // 청소 시작
                    simul(nx, ny, nd);
                    flag = true;
                    break;
                }
            }
            // 단순 회전
            d = (d+3) % 4;
        }

        // 네 방향 모두 청소했거나 벽인 경우
        if (!flag) {
            // 후진하기
            int bd = (origin + 2) % 4;
            int bx = x + dx[bd];
            int by = y + dy[bd];

            if (bx >= 0 && bx < n && by >= 0 && by < m) {
                // 만약 벽이 아니라면
                if (val[bx][by] != 1) {
                    // 방향은 유지하고 회전하기
                    simul(bx, by, origin);
                }
            }
        }
    }
}



// 삽질하다가 포기한 코드 ㅠ 이런 식으로 풀면 안 될 것 같다...!

//import java.io.*;
//import java.util.*;
//
//public class Main {
//    static int n, m, answer = 0;
//    static int[][] val;
//    static Map<Integer, Direction> map = new HashMap<>();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer stk;
//        StringBuilder sb = new StringBuilder("");
//
//        stk = new StringTokenizer(buf.readLine());
//        n = Integer.parseInt(stk.nextToken());
//        m = Integer.parseInt(stk.nextToken());
//
//        stk = new StringTokenizer(buf.readLine());
//
//        // 로봇 청소기의 좌표
//        int r = Integer.parseInt(stk.nextToken());
//        int c = Integer.parseInt(stk.nextToken());
//
//        // 바라보는 방향
//        // 0 북, 1 동, 2 남, 3 서
//        int d = Integer.parseInt(stk.nextToken());
//
//        // 빈칸은 0, 벽은 1, 로봇 청소기의 초기 위치는 빈칸.
//        val = new int[n][m];
//
//        for (int i = 0; i < n; i++) {
//            stk = new StringTokenizer(buf.readLine());
//            for (int j = 0; j < m; j++) {
//                val[i][j] = Integer.parseInt(stk.nextToken());
//            }
//        }
//
//        // 각 방향에 대해서 미리 정의해두기
//        // 상하좌우
//        // 북쪽(0) -> (-1,0)(1,0)(0,-1)(0,1)
//        // 남쪽(2) -> (1,0)(-1,0)(0,1)(0,-1)
//        // 동쪽(1) -> (0,1)(0,-1)(-1,0)(1,0)
//        // 서쪽(3) -> (0,-1)(0,1)(1,0)(-1,0)
//        map.put(0, new Direction(new Point(-1, 0), new Point(1, 0), new Point(0, -1), new Point(0, 1)));
//        map.put(1, new Direction(new Point(0, 1), new Point(0, -1), new Point(-1, 0), new Point(1, 0)));
//        map.put(2, new Direction(new Point(1, 0), new Point(-1, 0), new Point(0, 1), new Point(0, -1)));
//        map.put(3, new Direction(new Point(0, -1), new Point(0, 1), new Point(1, 0), new Point(-1, 0)));
//
//        simul(r, c, d, true);
//        System.out.println(answer);
//
//        buf2.flush();
//        buf.close();
//        buf2.close();
//    }
//
//    static void simul (int x, int y, int d, boolean clean) {
//        System.out.println(x + " " + y + " " + d);
//        if (clean) {
//            // 현재 위치 청소
//            val[x][y] = 2;
//            answer++;
//        }
//
//        Direction direction = map.get(d);
//        Point left = direction.left;
//
//        int nx = x + left.x;
//        int ny = y + left.y;
//
//        // 회전한 방향 구하기
//        int nd = absoluteDir(left.x, left.y);
//
//        // 청소하지 않은 공간이 존재한다면
//        if (!visited(nx, ny)) {
//            // 청소하기
//            val[nx][ny] = 2;
//            answer++;
//            // 다시 1번부터 진행하기
//            simul(nx, ny, nd, true);
//            return;
//        }
//        // 청소할 공간이 없다면
//        else {
//            simul(x, y, nd, false);
//        }
//
//        Point down = map.get(d).down;
//        int bx = x + down.x;
//        int by = y + down.y;
//        simul(bx, by, d, false);
//
//    }
//
//    // 절대적인 방향값 구해주기
//    // (-1,0) = 북 = 0, || (0,1) = 동 = 1 || (1,0) = 남 = 2 || (0,-1) = 서 = 3
//    static int absoluteDir (int x, int y) {
//        if (x==-1 && y==0) {
//            return 0;
//        } else if (x==0 && y==1) {
//            return 1;
//        } else if (x==1 && y==0) {
//            return 2;
//        } else {
//            return 3;
//        }
//    }
//
//    // 청소 상태 판단하기
//    static boolean visited(int x, int y) {
//        if (x >= 0 && x < n && y >= 0 && y < m) {
//            if (val[x][y] == 0)
//                return false;
//        }
//        return true;
//    }
//
//    static class Direction {
//        Point up;
//        Point down;
//        Point left;
//        Point right;
//
//        public Direction(Point up, Point down, Point left, Point right) {
//            this.up = up;
//            this.down = down;
//            this.left = left;
//            this.right = right;
//        }
//    }
//    static class Point {
//        int x;
//        int y;
//
//        public Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//}