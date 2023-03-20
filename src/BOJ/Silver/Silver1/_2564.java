package BOJ.Silver.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 경비원
public class _2564 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(buf.readLine());

        List<Point> points = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            stk = new StringTokenizer(buf.readLine());
            int direction = Integer.parseInt(stk.nextToken());
            int distance = Integer.parseInt(stk.nextToken());
            Point p = new Point(direction, distance, m, n);
            points.add(p);
        }

        stk = new StringTokenizer(buf.readLine());
        int targetDirection = Integer.parseInt(stk.nextToken());
        int target = Integer.parseInt(stk.nextToken());

        Point dong = new Point(targetDirection, target, m, n);
        int answer = 0;
        int temp = 0;

        // 마주보고 있는 X축
        if (targetDirection == 1) {
            temp = 2;
        } else if (targetDirection == 2) {
            temp = 1;
        } else if (targetDirection == 3) {
            temp = 4;
        } else {
            temp = 3;
        }

        for (Point point : points) {
            // 마주보고 있으면 왼<->오 어느 방향이 최단인지 알 수 없으니까 직접 구하기
            if (point.direction == temp) {
                if (point.direction == 1 || point.direction == 2) {
                    answer += Math.min(dong.y + point.y + dong.x + point.x, dong.y + point.y + n - dong.x + n - point.x);
                } else {
                    answer += Math.min(m - dong.y + m - point.y + dong.x + point.x, dong.y + point.y + dong.x + point.x);
                }
            } else {
                // 안 마주보면 그냥 동일한 방향으로 가면 된다.
                answer += Math.abs(dong.y - point.y) + Math.abs(dong.x - point.x);
            }
        }
        System.out.println(answer);
    }

    static class Point {
        int direction;
        int y;
        int x;

        Point(int direction, int distance, int c, int r) {
            this.direction = direction;

            // 북쪽
            if (direction == 1) {
                this.y = 0;
                this.x = distance;
            } else if (direction == 2) {
                // 남쪽
                this.y = c;
                this.x = distance;
            } else if (direction == 3) {
                // 서쪽
                this.y = distance;
                this.x = 0;
            } else {
                // 동쪽
                this.y = distance;
                this.x = r;
            }
        }
    }
}
