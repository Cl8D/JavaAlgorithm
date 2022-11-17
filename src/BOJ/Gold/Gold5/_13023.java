package BOJ.Gold.Gold5;

import java.io.*;
import java.util.*;

// ABCDE
public class _13023 {
    static int n, m, answer = 0;
    static List<Integer>[] friend;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        stk = new StringTokenizer(buf.readLine());

        // 사람의 수
        n = Integer.parseInt(stk.nextToken());

        // 친구 관계의 수
        m = Integer.parseInt(stk.nextToken());

        friend = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            friend[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(buf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            friend[a].add(b);
            friend[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            dfs(i, 0);

        }
        buf2.write(answer + "");
        buf2.flush();
        buf.close();
        buf2.close();
    }


    static void dfs(int idx, int depth) {
        if (depth == 4) {
            answer = 1;
            return;
        }

        for (Integer man : friend[idx]) {
            if (!visited[man]) {
                visited[man] = true;
                dfs(man, depth + 1);
            }
        }
        // https://www.acmicpc.net/board/view/34026
        // https://minhamina.tistory.com/50
        // 여기서 마지막 케이스를 보면, 다시 되돌아올 때 처음 방문 지점에 대해 표시가 되어 있으니까
        // depth=5까지 가지 못해서 안 되는 케이스가 있다.
        // 그래서 이걸 꼭 붙여줘야 한다...
        visited[idx] = false;
    }
}
