package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// N과 M (5)
public class _15654 {
    static int n, m;
    static int[] input;
    static int[] val;
    static boolean[] visited;
    static StringBuilder answer;

    // n개의! 자연수 중에서 m개를 고르는 수열
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        visited = new boolean[n];
        input = new int[n];

        stk = new StringTokenizer(buf.readLine());
        for(int i=0; i<n; i++)
            input[i] = Integer.parseInt(stk.nextToken());

        // 사전순으로 증가하는 수열을 만들기 위해서!
        Arrays.sort(input);

        // 시간초과 때문에...! (앞으로 이런 식으로 출력하도록 습관을 해두는 게 좋을 것 같다!)
        answer = new StringBuilder("");

        val = new int[m];

        dfs(0);
        buf2.write(answer.toString());

        buf2.flush();
        buf.close();
        buf2.close();

    }

    static void dfs(int level) {
        // 재귀의 깊이가 m과 같아지면, 탐색 과정에서 담았던 배열을 출력해주기
        if(level ==m) {
            for(int v : val) {
                answer.append(v).append(" ");
            }
            answer.append("\n");
            return;
        }

        // 이번에는 중복체크 해주기 - 중복되는 건 방문하면 안 되니까.
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                val[level] = input[i];

                // 자식노드 방문
                dfs(level + 1);

                // 자식노드 방문 후 다시 방문 여부 false로!
                visited[i] = false;
            }
        }

    }
}
