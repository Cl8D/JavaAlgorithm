package Programmers.Level2;

import java.util.*;

// 게임 맵 최단거리
class GameMapDistance {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        // 0이 벽, 1이 길.
        // 플레이어는 (1,1) 상대는 (n, m)
        return bfs(maps);
    }

    private int bfs(int[][] maps) {
        Queue<Move> queue = new LinkedList<>();
        // 처음에 플레이어가 있는 칸도 1칸.
        queue.add(new Move(0, 0, 1));
        maps[0][0] = 0;

        int n = maps.length;
        int m = maps[0].length;

        int answer = 9999;

        while(!queue.isEmpty()) {
            Move current = queue.poll();
            int curX = current.x;
            int curY = current.y;
            int curCnt = current.count;

            for (int i=0; i<dx.length; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || maps[nx][ny] == 0) {
                    continue;
                }

                if (nx == n-1 && ny == m-1) {
                    // 마지막에 도달한 칸도 카운트로 체크해야 한다.
                    answer = Math.min(answer, curCnt+1);
                    continue;
                }

                maps[nx][ny] = 0;
                queue.add(new Move(nx, ny, curCnt+1));
            }
        }

        if (answer == 9999) {
            return -1;
        }
        return answer;
    }

    static class Move {
        int x;
        int y;
        int count;

        public Move(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}