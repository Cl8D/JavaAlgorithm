package BOJ.Silver.Silver3;

import java.io.*;
import java.util.*;

// N과 M(2)
public class _15650 {
    static int n, m;
    static int[] val;

    // 1~n까지의 자연수 중에서 중복없이 m개 고르는 수열
    // 고른 수열이 오름차순이 되도록
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        val = new int[m];

        dfs(1, 0);

        buf2.flush();
        buf.close();
        buf2.close();

    }

    // 오름차순이 되도록 하기 위해서 어디서부터 시작하는지 나타내는 start 변수를 추가해주기.
    static void dfs(int start, int level) {
        // 재귀의 깊이가 m과 같아지면, 탐색 과정에서 담았던 배열을 출력해주기
        if(level ==m) {
            for(int v : val) {
                System.out.print(v + " ");
            }
            System.out.println();
            return;
        }

        for(int i=start; i<=n; i++) {
            // 또한, 이전 문제와 다르게 방문처리를 해줄 필요가 없음.
            // 어차피 오름차순이니까, 이전에 방문했던 건 자연스럽게 방문하지 않게 된다!
            // 깊이를 index로 해서 값을 저장해주기
            val[level] = i;

            // 그 다음 자식 노드 방문을 위해 level을 1 증가시켜주기.
            // 오름차순으로 방문해야 하니까, i+1부터 시작하도록!
            dfs(i+1, level+1);

        }
    }
}
