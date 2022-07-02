package BOJ.Silver.Silver3;

import java.io.*;
import java.util.StringTokenizer;

// n과 m(1)
public class _15649 {
    static int n, m;
    static boolean[] visited;
    static int[] val;

    // 1~n까지의 자연수 중에서 중복없이 m개 고르는 수열
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        // 유망한 노드인지 검사하기 - 방문 상태 판단
        // 이는 중복되는 수를 검사하지 않기 위해
        visited = new boolean[n+1];
        val = new int[m];

        dfs(0);

        buf2.flush();
        buf.close();
        buf2.close();

    }

    static void dfs(int level) {
        // 재귀의 깊이가 m과 같아지면, 탐색 과정에서 담았던 배열을 출력해주기
        if(level ==m) {
            for(int v : val) {
                System.out.print(v + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=n; i++) {
            // 만약 방문하지 않은 노드라면
            if(!visited[i]) {
                // 방문 처리를 진행해주기
                visited[i] = true;

                // 깊이를 index로 해서 값을 저장해주기
                val[level] = i;

                // 그 다음 자식 노드 방문을 위해 level을 1 증가시켜주기.
                dfs(level+1);

                // 자식 노드 방문이 끝나면, 방문했던 걸 다시 방문 안 한 상태로 변경하기
                visited[i] = false;
            }
        }
    }
}

