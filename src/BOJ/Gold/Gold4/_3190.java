package BOJ.Gold.Gold4;

import java.io.*;
import java.util.*;

// 뱀
public class _3190 {
    static int n;
    static Deque<Type> queue;
    static Map<Integer, String> snake;

    // 위, 오른쪽, 아래, 왼쪽,
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(buf.readLine());
        int k = Integer.parseInt(buf.readLine());
        int[][] val = new int[n + 1][n + 1];

        // 사과의 위치
        for (int i = 0; i < k; i++) {
            stk = new StringTokenizer(buf.readLine());
            int row = Integer.parseInt(stk.nextToken());
            int col = Integer.parseInt(stk.nextToken());
            val[row][col] = 2;
        }

        // 방향 변환 횟수
        int l = Integer.parseInt(buf.readLine());
        snake = new HashMap<>();

        for (int i = 0; i < l; i++) {
            stk = new StringTokenizer(buf.readLine());
            // x초가 끝난 뒤에 왼쪽(L), 오른쪽(D)으로 90도 회전
            int x = Integer.parseInt(stk.nextToken());
            String c = stk.nextToken();
            snake.put(x, c);
        }

        /*
            * 만약 진행 방향이 (0,1)이라면 (R)
            - 오른쪽 회전: (1, 0), 왼쪽 회전 (-1, 0)

            * 진행 방향이 (0, -1)이라면 (L)
            - 오른쪽 회전 (-1,0) 왼쪽 회전(1,0)

            * 진행 방향이 (1, 0)이라면 (D)
            - 오른쪽 회전 (0, -1) 왼쪽 회전 (0, 1)

            * 진행 방향이 (-1,0)이라면 (U)
            - 오른쪽 회전 (0, 1), 왼쪽 회전(0, -1)
         */

        queue = new LinkedList<>();
        queue.add(new Type(1, 1)); // 초기 위치 넣어주기

        int x = 1, y = 1; // 현재 뱀의 위치
        val[1][1] = 1; // 뱀의 초기 위치에는 몸이 있으니까 1로.
        int time = 0; // 시간
        int direction = 1; // 초기 방향은 오른쪽으로 쭉 진행

        while (true) {
            // 움직여야 하는 시간이 있다면
            if (snake.containsKey(time)) {
                // 오른쪽으로 회전
                // 이런 식으로 쓰는 게 약간 구현 문제의 고유한 규칙 느낌! 잘 기억해두도록 해야겠다.
                if (snake.get(time).equals("D")) {
                    direction = (direction + 1) % 4;
                }
                // 왼쪽으로 회전
                else {
                    direction = (direction + 3) % 4;
                }
            }

            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 머리를 다음 칸으로 위치해주기 - 사과가 있든 없든 몸이 이동하니까
            queue.addFirst(new Type(nx, ny));

            // 밖으로 나가는 경우
            if (nx < 1 || nx > n || ny < 1 || ny > n) {
                time++;
                break;
            }

            // 사과가 있는 위치라면
            if (val[nx][ny] == 2) {
                val[nx][ny] = 1; // 사과 먹고, 몸이 있다는 표시!
            }
            // 사과가 없다면
            else if (val[nx][ny] == 0) {
                val[nx][ny] = 1; // 몸이 있다는 표시!
                // 꼬리가 있는 칸은 비워주기
                val[queue.peekLast().x][queue.peekLast().y] = 0;
                // 큐에서도 꼬리 제거해주기
                queue.pollLast();
            } else {
                // 자기 자신과 부딪힌다면
                time++;
                break;
            }
            // 현재 위치 및 시간 갱신
            x = nx;
            y = ny;
            time++;
        }

        buf2.write(time+"");
        buf2.flush();
        buf.close();
        buf2.close();

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
