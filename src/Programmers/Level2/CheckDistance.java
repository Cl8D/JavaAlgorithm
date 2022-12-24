package Programmers.Level2;

import java.util.*;

// 거리두기 확인하기
class CheckDistance {
    private static Character[][] map;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static final int SIZE = 5, LIMIT_DISTANCE = 2;

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int idx = 0;

        for (int i=0; i<SIZE; i++) {
            initMap(places, i);
            answer[idx++] = search();
        }

        return answer;
    }

    private void initMap(String[][] places, int mapIdx) {
        map = new Character[SIZE][SIZE];
        String[] tempMap = places[mapIdx];

        for (int i=0; i<SIZE; i++) {
            for (int j=0; j<SIZE; j++) {
                map[i][j] = tempMap[i].charAt(j);
            }
        }
    }

    private int search() {
        // P -> 응시자 자리
        // O -> 빈 테이블, X -> 파티션
        for (int i=0; i<SIZE; i++) {
            for (int j=0; j<SIZE; j++) {
                if (map[i][j] == 'P') {
                    boolean result = bfs(i, j);
                    if (!result) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }


    private boolean bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        while(!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i=0; i<dx.length; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= SIZE || ny < 0 || ny >= SIZE || (nx == x && ny == y)) {
                    continue;
                }

                // 거리 구할 때 초기 값(x, y)을 기준으로 구해야 함!!!... 나는 바보야
                int distance = Math.abs(x- nx) + Math.abs(y - ny);

                // 그 다음 응시자까지의 거리가 2 이하일 경우
                if (map[nx][ny] == 'P' && distance <= LIMIT_DISTANCE) {
                    return false;
                }

                // 거리는 아직 2가 안되었고, 그 다음 위치가 빈 곳이라면
                if (map[nx][ny] == 'O' && distance < LIMIT_DISTANCE) {
                    queue.add(new Point(nx, ny));
                }
            }
        }

        return true;
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}