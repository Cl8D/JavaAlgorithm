package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// N과 M(3)
public class _15651 {
    static int n, m;
    static int[] val;
    static StringBuilder answer;

    // 1~n까지의 자연수 중에서 m개를 고르는 수열
    // 같은 수를 여러 번 골라도 된다!
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        // 시간초과 때문에...!
        answer = new StringBuilder("");

        val = new int[m];

        dfs(0);
        buf2.write(answer.toString());

        buf2.flush();
        buf.close();
        buf2.close();

    }

    // 오름차순이 되도록 하기 위해서 어디서부터 시작하는지 나타내는 start 변수를 추가해주기.
    static void dfs(int level) {
        // 재귀의 깊이가 m과 같아지면, 탐색 과정에서 담았던 배열을 출력해주기
        if(level ==m) {
            for(int v : val) {
                answer.append(v).append(" ");
            }
            answer.append("\n");
            return;
        }

        // 중복이 가능하고, 같은 수를 여러 번 골라도 되니까 굳이 방문처리를 할 필요 없음!
        for(int i=1; i<=n; i++) {
            // 깊이를 index로 해서 값을 저장해주기
            val[level] = i;

            // 그 다음 자식 노드 방문을 위해 level을 1 증가시켜주기.
            dfs(level+1);

        }
    }
}
