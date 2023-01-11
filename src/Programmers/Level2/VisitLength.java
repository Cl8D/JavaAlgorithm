package Programmers.Level2;

import java.util.*;

// 방문 길이
class VisitLength {
    private static final List<Road> list = new ArrayList<>();
    private static final int MAX = 10;

    public int solution(String dirs) {
        int answer = 0;

        // 초기 시작 값을 가운데 값으로 잡아버리기.
        int x = 5, y = 5;
        for (Character dir : dirs.toCharArray()) {
            int[] move = getDirection(dir);
            int dx = move[0];
            int dy = move[1];

            int nx = x + dx;
            int ny = y + dy;

            if (nx < 0 || nx > MAX || ny < 0 || ny > MAX) {
                continue;
            }

            Road road = new Road(x, y, nx, ny);

            // (1, 1) -> (1, 2)와 (1, 2) -> (1, 1)은 동일한 길이기 때문에 체크.
            Road reverseRoad = new Road(nx, ny, x, y);

            if (!list.contains(road) && !list.contains(reverseRoad)) {
                list.add(road);
                answer++;
            }
            x = nx;
            y = ny;
        }

        return answer;
    }

    private int[] getDirection(Character dir) {
        int[] move = new int[2];
        if (dir == 'U') {
            move[0] = -1;
            move[1] = 0;
        } else if (dir == 'D') {
            move[0] = 1;
            move[1] = 0;
        } else if (dir == 'L') {
            move[0] = 0;
            move[1] = -1;
        } else {
            move[0] = 0;
            move[1] = 1;
        }
        return move;
    }

    static class Road {
        int prevX;
        int prevY;
        int nextX;
        int nextY;

        public Road(int prevX, int prevY, int nextX, int nextY) {
            this.prevX = prevX;
            this.prevY = prevY;
            this.nextX = nextX;
            this.nextY = nextY;
        }

        @Override
        public boolean equals(Object obj) {
            Road road = (Road) obj;
            if (road.prevX == prevX && road.prevY == prevY && road.nextX == nextX && road.nextY == nextY) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(prevX, prevY, nextX, nextY);
        }

        public String toString() {
            return prevX + " " + prevY + " " + nextX + " " + nextY;
        }
    }
}