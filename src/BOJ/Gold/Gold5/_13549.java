package BOJ.Gold.Gold5;

import java.io.*;
import java.util.*;

// 숨바꼭질 3
public class _13549 {
    private static Queue<Location> queue;
    private static int[] visited;
    private static int n, k;
    private static final int MAX = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        stk = new StringTokenizer(buf.readLine());

        // 수빈이의 위치
        n = Integer.parseInt(stk.nextToken());
        // 가야하는 곳
        k = Integer.parseInt(stk.nextToken());

        queue= new LinkedList<>();
        queue.add(new Location(n, 0));

        // BFS의 경우 모든 간선의 가중치가 동일해야 하는데, 여기서는 방문 순서에 따라서 우연히 BFS로도 정답을 찾을 수 있는 것이다.
        // 원래는 0-1 BFS라고 해서, 가중치가 0인 간선에 연결된 정점은 큐의 맨 뒤가 아닌 맨 앞에 넣어야 한다.

        visited = new int[MAX+1];
        Arrays.fill(visited, -1);
        visited[n] = 0;

        while (!queue.isEmpty()) {
            Location current = queue.poll();
            int time = current.time;
            int location = current.loc;

            if (location == k) {
                System.out.println(time);
                break;
            }

            int rush = location * 2;
            checkAndPush(rush, time);

            int prev = location - 1;
            checkAndPush(prev, time + 1);

            int next = location + 1;
            checkAndPush(next, time + 1);
        }

        buf2.flush();
        buf.close();
        buf2.close();
    }

    private static void checkAndPush(final int nextLoc, int nextTime) {
        // BFS니까 방문하지 않은 곳에 대해서만 체크해줘도 된당
        if (nextLoc < 0 || nextLoc > MAX || visited[nextLoc] != -1) {
            return;
        }
        visited[nextLoc] = nextTime;
        queue.add(new Location(nextLoc, nextTime));
    }


    private static class Location {
        int loc;
        int time;

        public Location(final int loc, final int time) {
            this.loc = loc;
            this.time = time;
        }
    }
}
