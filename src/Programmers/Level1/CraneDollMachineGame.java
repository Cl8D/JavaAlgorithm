package Programmers.Level1;

import java.util.*;

// 크레인 인형뽑기 게임
class CraneDollMachineGame {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        // 가장 상단에 있는 인형의 위치를 기록.
        Point[] location = new Point[board.length];

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (location[j] == null && board[i][j] != 0) {
                    location[j] = new Point(i, j);
                }
            }
        }

        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            if (location[move-1] == null) {
                continue;
            }

            Point current = location[move-1];
            int doll = board[current.x][current.y];
            if (!stack.isEmpty() && stack.peek() == doll) {
                stack.pop();
                answer++;
            } else {
                stack.push(doll);
            }

            board[current.x][current.y] = 0;
            int nx = current.x + 1;
            if (nx < board.length && board[nx][current.y] != 0) {
                location[move-1] = new Point(nx, current.y);
            } else {
                location[move-1] = null;
            }
        }

        // 사라진 인형의 개수를 구해야 하니까 * 2 해주기!
        return answer * 2;
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