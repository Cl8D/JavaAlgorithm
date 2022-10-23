package BOJ.Silver.Silver1;

import java.io.*;
import java.util.*;

// 맥주 마시면서 걸어가기
public class _9205 {
    static Queue<Integer> queue;
    static int n;
    static boolean flag;
    static List<Point> list;

    static List<List<Integer>> graph;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        // 맥주 한 박스에는 맥주 20개. -> 출발할 때 기본적으로 한 박스를 들고 간다.
        // 즉, 50 * 20 = 1000미터는 갈 수 있다
        // 50미터에 한 병씩 마심
        // 편의점을 나선 직후에도 1병은 무조건 마셔야 함
        // 들고 다닐 수 있는 건 최대 20병 = 1000미터 분량까지만 가능

        // 좌표는 음수가 나올 수 있기 때문에 별도의 처리가 필요하다.
        // 두 좌표 사이의 거리는 x 좌표 사이의 거리 + y 좌표 사이의 거리로 구한다.
        int t = Integer.parseInt(buf.readLine());

        for (int i = 0; i < t; i++) {
            // 맥주를 파는 편의점의 개수
            n = Integer.parseInt(buf.readLine());
            flag = false;
            list = new ArrayList<>();

            // 집, 편의점, 페스티벌 위치 저장
            for (int j = 0; j < n + 2; j++) {
                stk = new StringTokenizer(buf.readLine());
                int x = Integer.parseInt(stk.nextToken());
                int y = Integer.parseInt(stk.nextToken());
                list.add(new Point(x, y));
            }

            // 두 지점 사이가 1000m 이하인 정점을 서로 연결해주기 (양방향 그래프)
            graph = new ArrayList<>();
            for (int j = 0; j < n + 2; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < n + 2; j++) {
                for (int k = j + 1; k < n + 2; k++) {
                    // 정점 사이의 거리 체크
                    int distance = Math.abs(list.get(j).x - list.get(k).x)
                            + Math.abs(list.get(j).y - list.get(k).y);
                    if (distance <= 1000) {
                        graph.get(j).add(k);
                        graph.get(k).add(j);
                    }
                }
            }

            visited = new boolean[n + 2];
            queue = new LinkedList<>();

            // 시작 지점 진행
            queue.add(0);
            visited[0] = true;

            bfs();

            if (flag) {
                sb.append("happy").append("\n");
            } else {
                sb.append("sad").append("\n");
            }
        }

        buf2.write(sb.toString());
        buf2.flush();
        buf.close();
        buf2.close();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 끝점에 도달했다면 true, 아니라면 false
            if (current == n + 1) {
                flag = true;
                break;
            }

            // 현재 정점과 연결되어 있는 다른 정점을 방문해나가기
            // 어차피 1000미터 이내의 값들만 탐색하게 된다.
            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
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