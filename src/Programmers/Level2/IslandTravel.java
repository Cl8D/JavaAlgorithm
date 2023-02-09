package Programmers.Level2;

import java.util.*;

// 무인도 여행
class IslandTravel {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static String[][] map;

    public int[] solution(String[] maps) {
        int[] answer = {};

        map = new String[maps.length][maps[0].length()];

        for (int i=0; i<maps.length; i++) {
            String[] rowMap = maps[i].split("");
            for (int j=0; j<rowMap.length; j++) {
                map[i][j] = rowMap[j];
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[i].length; j++) {
                if (!map[i][j].equals("X")) {
                    int total = bfs(i, j);
                    ans.add(total);
                }
            }
        }

        if (ans.size() == 0) {
            return new int[]{-1};
        }

        ans.sort(Comparator.naturalOrder());
        answer = new int[ans.size()];
        int ansIdx = 0;
        for(int value : ans) {
            answer[ansIdx++] = value;
        }

        return answer;
    }

    private int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        int total = Integer.parseInt(map[x][y]);
        map[x][y] = "X";

        while(!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i=0; i<dx.length; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                    continue;
                }

                if (!map[nx][ny].equals("X")) {
                    total += Integer.parseInt(map[nx][ny]);
                    map[nx][ny] = "X";
                    queue.add(new Point(nx, ny));
                }
            }
        }
        return total;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}