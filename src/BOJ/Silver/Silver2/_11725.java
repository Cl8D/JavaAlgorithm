package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 트리의 부모 찾기
public class _11725 {
    static int n;
    static int[] parents;
    static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        n = Integer.parseInt(buf.readLine());
        parents = new int[n+1];
        tree = new ArrayList[n+1];

        for(int i=1; i<=n; i++)
            tree[i] = new ArrayList<>();

        for (int i = 0; i < n-1; i++) {
            stk = new StringTokenizer(buf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        // 루트노드인 1부터 탐색 시작
        dfs(1);
        for(int i=2; i<=n; i++)
            buf2.write(parents[i] + "\n");

        buf2.flush();
        buf.close();
        buf2.close();

    }

    // idx와 연결된 tree[idx]의 요소들 (val)이 자식이 된다.
    // idx는 부모, val이 자식이 되는 것.
    // 이미 찾아졌으면 배열에 값이 할당되었을 테니 0이 아니기 때문에 0이 아닌 경우 패스
    static void dfs(int idx) {
        for(int val : tree[idx]) {
            if(parents[val] == 0) {
                parents[val] = idx;
                dfs(val);
            }
        }
    }
}
