package Inflearn.dfs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 15. 피자 배달 거리(DFS 활용)
public class _0815 {
    static int n, m, len;
    static List<Point> pizza, home;
    static int answer = Integer.MAX_VALUE;
    static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        // 각 집의 피자배달거리 = 집과 피자집 거리 중 최소값
        // 도시의 피자 배달 거리 = 각 집의 피자 배달 거리의 합
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        pizza = new ArrayList<>();
        home = new ArrayList<>();

        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            for(int j=0; j<n; j++) {
                int value = Integer.parseInt(stk.nextToken());
                if (value == 1)
                    home.add(new Point(i, j));
                else if (value == 2)
                    pizza.add(new Point(i, j));
            }
        }

        // 피자집의 개수 담아주기
        len = pizza.size();

        // 우리는 len C m을 구하는 것, 즉 len개 중에서 m개 뽑는 것
        temp = new int[m];

        dfs(0, 0);
        System.out.println(answer);

    }

    // 조합은 level과 start로 시작한다!
    static void dfs(int level, int start) {
        if(level == m) {
            int cityDistance = 0;
            for (Point h : home) {
                int distance = Integer.MAX_VALUE;

                for(int idx: temp) {
                    // 집과 피자집 거리의 최소 거리 구하기 = 집의 피자 배달 거리
                    distance = Math.min(distance, Math.abs(h.x - pizza.get(idx).x) + Math.abs(h.y - pizza.get(idx).y));
                }

                // 도시의 피자 배달 거리 구하기
                cityDistance += distance;
            }

            // 최소인 값으로 변경
            answer = Math.min(answer, cityDistance);


        } else {
            // 조합을 구할 때 a개에서 b개를 뽑는다고 가정하면
            // len 자리에 a가 들어가고, temp의 사이즈가 b가 되는 것!
            for(int i=start; i<len; i++) {
                // 피자 가게의 인덱스가 들어간다고 생각하자.
                // 피자집 중에서 m개씩 뽑을 수 있는 모든 경우의 수를 돈다고 생각하기!
                // 즉, temp에는 len개 중에서 m개를 뽑는 경우의 수들이 들어가는 것!!
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