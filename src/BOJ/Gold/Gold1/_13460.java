package BOJ.Gold.Gold1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 구슬 탈출 2
public class _13460 {
    static int n, m, answer = 0;
    static char[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][][][] visited;
    static Queue<Type> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        board = new char[n][m];
        visited = new boolean[n][m][n][m];

        queue = new LinkedList<>();

        int rx = 0, ry = 0, bx = 0, by = 0;
        for(int i=0; i<n; i++) {
            board[i] = buf.readLine().toCharArray();
            for(int j=0; j<m; j++) {
                if(board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                    board[i][j] = '.';
                }
                else if(board[i][j] == 'B') {
                    bx = i;
                    by = j;
                    board[i][j] = '.';
                }
            }
        }

        // 처음에 큐를 2개로 나눴었는데, 그냥 한 개에 박아두는 게 좋은 것 같다. 동시에 움직이니까 따로 생각 안 해줘도 되어서 편함...!
        queue.add(new Type(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        bfs(rx, ry, bx, by);
        if(answer == 0)
            System.out.println(-1);
        else
            System.out.println(answer);

    }

    static void bfs(int rx, int ry, int bx, int by) {
        while(!queue.isEmpty()) {
            Type current = queue.poll();

            if (current.count <= 10) {
                // 구슬 위치 체크
                // 빨간 구슬만 들어간 경우 성공
                // 이 조건을 구슬 이동 뒤 moved된 좌표값으로도 했었는데 이는 구슬이 겹쳐있는 경우를 고려하지 않았던 거여서 ㅠㅠㅠㅠ
                // 마지막 조건까지 끝나고 큐에 삽입됨 => 빼냈을 때 현재 조건에 빨간 구슬만 구멍에 들어갔다면 정답으로 해줘야함!! 이부분 진짜 중요!
                if (board[current.rx][current.ry] == 'O' && board[current.bx][current.by] != 'O') {
                    answer = current.count;
                    return;
                }

                // 구슬 이동시키기
                for (int i = 0; i < dx.length; i++) {
                    // 이동한 위치
                    int[] moveRed = move(current.rx, current.ry, i);
                    int[] moveBlue = move(current.bx, current.by, i);

                    // 둘 다 구멍으로 들어갔거나, 파란색만 들어간 경우 실패
                    if(board[moveBlue[0]][moveBlue[1]] == 'O')
                        continue;

//                    if (board[moveRed[0]][moveRed[1]] == 'O' && board[moveBlue[0]][moveBlue[1]] != 'O') {
//                        answer = current.count;
//                        return;
//                    }

                    // 둘 다 아직 구멍이 아닌 상태라면, 두 개의 구슬이 같은 위치에 있는지 판단하기
                    if(board[moveRed[0]][moveRed[1]] != 'O' && board[moveBlue[0]][moveBlue[1]] != 'O') {
                        if (moveRed[0] == moveBlue[0] && moveRed[1] == moveBlue[1]) {
                            // 어떤 구슬이 더 많이 이동했는지 판단해서, 덜 이동하도록 만들기
                            if (i == 0) { // 위쪽
                                if (current.rx < current.bx) // 빨간색이 더 위에 있었으면 파란색을 이전의 위치로 이동시키기
                                    moveBlue[0] += 1;
                                else
                                    moveRed[0] += 1;
                            } else if (i == 1) { // 아래
                                if (current.rx > current.bx)  // 빨간색이 더 아래 > 파란색을 이전으로
                                    moveBlue[0] -= 1;
                                else
                                    moveRed[0] -= 1;
                            } else if (i == 2) {
                                if (current.ry > current.by) // 빨간색이 더 오른쪽
                                    moveBlue[1] -= 1;
                                else
                                    moveRed[1] -= 1;
                            } else {
                                if (current.ry < current.by)
                                    moveBlue[1] += 1;
                                else
                                    moveRed[1] += 1;
                            }
                        }
                    }

                    // 구슬이 도착한 지점을 방문처리하고 큐에 추가해주기
                    // 근데 내 경험상 bfs는 방문처리가 딱히 필요없었던 것 같아서 생략도 해봤는데, 이래도 잘 동작하기는 한다.
                    // 단, 방문처리를 했을 때 시간이 훠어어얼씬 짧게 걸리기 때문에 하는 게 맞는 풀이 같음!
                    // (방문처리 안함: 1284ms, 방문처리 함: 128ms) + 심지어 메모리도 엄청 차이남!
                    // (방문처리 안함: 574560kb, 함: 14368kb...) 방문처리의 중요성을 깨달았다...!
                    if(!visited[moveRed[0]][moveRed[1]][moveBlue[0]][moveBlue[1]]) {
                        visited[moveRed[0]][moveRed[1]][moveBlue[0]][moveBlue[1]] = true;
                        queue.add(new Type(moveRed[0], moveRed[1], moveBlue[0], moveBlue[1], current.count+1));
                    }


                }
            }
        }

    }

    private static int[] move(int colorX, int colorY, int i) {
        int[] marble = {colorX, colorY};
        while(true) {
            marble[0] += dx[i];
            marble[1] += dy[i];

            // 구멍인 경우 종료
            if(board[marble[0]][marble[1]] == 'O')
                break;
                // 벽인 경우 다시 이전의 위치로
            else if(board[marble[0]][marble[1]] == '#') {
                marble[0] -= dx[i];
                marble[1] -= dy[i];
                break;
            }
        }
        return marble;
    }


    static class Type {
        int rx;
        int ry;
        int bx;
        int by;
        int count;

        public Type(int rx, int ry, int bx, int by, int count) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.count = count;
        }
    }


}