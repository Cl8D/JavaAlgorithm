package BOJ.Gold.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 치킨 배달
public class _15686 {
    static List<Point> home, chicken;
    static int n, m, len;
    static int answer=Integer.MAX_VALUE;
    static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            for(int j=0; j<n; j++) {
                int value = Integer.parseInt(stk.nextToken());
                if (value == 1)
                    home.add(new Point(i, j));
                else if (value == 2)
                    chicken.add(new Point(i, j));
            }
        }

        len = chicken.size();

        temp = new int[m];

        dfs(0, 0);
        System.out.println(answer);


    }

    static void dfs(int level, int start) {
        if(level == m) {
            int chickenDistance = 0;
            for (Point h : home) {
                int homeDistance = Integer.MAX_VALUE;

                for(int idx : temp) {
                    homeDistance = Math.min(homeDistance, Math.abs(h.x-chicken.get(idx).x) + Math.abs(h.y-chicken.get(idx).y));
                }
                chickenDistance += homeDistance;
            }
            answer = Math.min(chickenDistance, answer);

        } else {
            for(int i=start; i<len; i++) {
                temp[level] = i;
                dfs(level+1, i+1);
            }

        }
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