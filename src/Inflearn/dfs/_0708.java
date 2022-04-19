package Inflearn.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 8. 송아지 찾기 (BFS)
public class _0708 {
    static int[] jump = {1, -1, 5};

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        int s = Integer.parseInt(stk.nextToken());
        int e = Integer.parseInt(stk.nextToken());

        System.out.println(bfs(s, e));

    }

    // bfs -> 최단거리를 구하는 문제라고도 볼 수 있다.
    /*
        s=5, e=14일 때
        level=0 -> 5
        level=1 -> 6, 4, 10으로 갈 수 있음 (한 번의 점프)
        level=2 -> 6(7, *5, 11) | 4(*5, 3, 9) | 10(*11, *9, 15)  (두 번의 점프)
        level=3 -> 7(8, *6, 12), 11(*12, *10, 16) | 3(*4, 2, *8), 9(*10, *8, @14) -> 목표인 e 찾았으니 종료
        - 이때 *를 한 건 이미 방문한 경우를 의미함
     */
    static int bfs(int s, int e) {
        // 한 번 방문한 것은 다시 방문할 필요가 없음 (시간복잡도)
        boolean[] visited = new boolean[10001];

        Queue<Integer> queue = new LinkedList<>();
        // 출발 지점 방문했음
        visited[s] = true;
        // 루트 노드의 레벨은 0레벨.
        int level = 0; // 여기서는 레벨이 곧 최단 거리라고 볼 수 있음!
        // 큐에 집어넣음
        queue.add(s);

        while(!queue.isEmpty()) {
            // 레벨 탐색 시작 - 해당 레벨에 있는 데이터들 탐색
            int len = queue.size();
            for(int i=0; i<len; i++) {
                // 해당 레벨의 데이터 1개씩 꺼내기
                int current = queue.poll();

                for(int j=0; j<jump.length; j++) {
                    // 해당 레벨의 자식 노드 (즉, 다음 레벨)의 데이터 계산.
                    int jump_current = current + jump[j];

                    if(jump_current == e)
                        return level+1;

                    // 해당 데이터가 1~10000 범위에 있고, 방문 여부 체크
                    if(jump_current >=1 && jump_current <=10000 && !visited[jump_current]) {
                        // 방문 체크 및 큐에 넣어주기
                        visited[jump_current] = true;
                        queue.add(jump_current);

                    }
                }
            }
            // 탐색이 끝났으면 레벨 증가
            level++;
        }
        return 0;
    }
}

