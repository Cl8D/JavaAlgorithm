package BOJ.Silver.Silver5;

import java.io.*;
import java.util.*;

// 좌표 정렬하기
public class _11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        List<Point> list = new ArrayList<>();

        int n = Integer.parseInt(buf.readLine());
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(buf.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            list.add(new Point(x, y));
        }
        Collections.sort(list, (o1, o2) -> {
            if(o1.x  == o2.x) {
                return o1.y - o2.y;
            }
            return o1.x - o2.x;
        });

        StringBuilder sb = new StringBuilder();
        for(Point p : list) {
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }
        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();

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
