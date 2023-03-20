package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

// 리코쳇 로봇
class RicochetRobot {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static final Queue<Point> queue = new LinkedList<>();
    private static String[][] map;
    private static boolean[][] visited;

    public int solution(String[] board) {
        map = new String[board.length][board[0].length()];
        visited = new boolean[board.length][board[0].length()];

        for (int i = 0; i < board.length; i++) {
            String[] rows = board[i].split("");
            for (int j = 0; j < rows.length; j++) {
                map[i][j] = rows[j];
                if (map[i][j].equals("R")) {
                    queue.add(new Point(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        return bfs();
    }

    private int bfs() {
        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (map[current.x][current.y].equals("G")) {
                return current.count;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = current.x;
                int ny = current.y;

                while (nx + dx[i] >= 0 && nx + dx[i] < map.length && ny + dy[i] >= 0
                        && ny + dy[i] < map[0].length && !map[nx + dx[i]][ny + dy[i]].equals("D")) {
                    nx += dx[i];
                    ny += dy[i];
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny, current.count + 1));
                }
            }
        }
        return -1;
    }

    private class Point {
        int x;
        int y;
        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", count=" + count +
                    '}';
        }
    }
}


