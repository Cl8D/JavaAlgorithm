package Programmers.Level2;

import java.util.*;

// 미로 탈출
class MazeEscape {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static String[][] maze;

    public int solution(String[] maps) {
        Info startPoint = init(maps, "S");
        int startToLever = bfs("L", startPoint);
        if (startToLever == -1) {
            return -1;
        }

        startPoint = init(maps, "L");
        int levelToExit = bfs("E", startPoint);
        if (levelToExit == -1) {
            return -1;
        }

        return startToLever + levelToExit;
    }

    private Info init(String[] maps, String start) {
        Info startPoint = null;
        maze = new String[maps.length][maps[0].length()];

        for (int i=0; i<maps.length; i++) {
            String map = maps[i];
            String[] part = map.split("");
            for (int j=0; j<part.length; j++) {
                if (part[j].equals(start)) {
                    startPoint = new Info(i, j, 0);
                }
                maze[i][j] = part[j];
            }
        }

        return startPoint;
    }


    private int bfs(String checkFlag, Info startPoint) {
        Queue<Info> queue = new LinkedList<>();
        queue.add(startPoint);
        maze[startPoint.x][startPoint.y] = "X";

        while(!queue.isEmpty()) {
            Info current = queue.poll();
            for (int i=0; i<dx.length; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                int distance = current.distance;

                if (nx < 0 || nx >= maze.length || ny < 0 || ny >= maze[0].length || maze[nx][ny].equals("X")) {
                    continue;
                }

                if (maze[nx][ny].equals(checkFlag)) {
                    return distance + 1;
                }

                maze[nx][ny] = "X";
                queue.add(new Info(nx, ny, distance + 1));
            }
        }
        return -1;
    }

    static class Info {
        int x;
        int y;
        int distance;

        public Info(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}