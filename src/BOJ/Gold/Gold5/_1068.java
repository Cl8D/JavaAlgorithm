package BOJ.Gold.Gold5;

import java.io.*;
import java.util.*;

// 트리
public class _1068 {
    static int n, answer = 0;
    static List<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder("");

        n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        int rootNode = -1;

        // 각 노드별 부모 번호가 들어간다.
        // 부모가 없다면 -1을 넣어준다,
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(stk.nextToken());
            if (parent == -1) {
                rootNode = i;
                continue;
            }
            tree[parent].add(i);
        }

        int removeNode = Integer.parseInt(buf.readLine());

        // 지워야 되는 게 루트 노드면 그냥 0개.
        if (removeNode == rootNode) {
            buf2.write(0 + "");
            buf2.flush();
            return;
        }

        // 지워야 하는 노드를 기준으로 지우기 시작.
        removeChild(removeNode);
        // 루트 노드부터 탐색 시작
        dfs(rootNode);

        buf2.write(answer+"");
        buf2.flush();
        buf.close();
        buf2.close();
    }

    static void dfs(int root) {
        // 자식이 없음 = 루트 노드.
        if (tree[root].isEmpty()) {
            answer++;
            return;
        }

        // 돌면서 계속 체크해주기.
        for(int child: tree[root]) {
            dfs(child);
        }
    }

    // 현재 트리 구조.
    // 0 -> 1, 2
    // 1 -> 3, 4
    static void removeChild(int idx) {
        // 지워야 하는 노드를 자식으로 가진 부모 노드 탐색해서 자식 노드 지우기.
        for(List<Integer> childs : tree) {
            if (childs.contains(idx)) {
                // 그냥 넘기면 index로 인식해서 outofbounds 에러 발생함
                childs.remove((Object) idx);
            }
        }

        for(int val : tree[idx]) {
            tree[idx].remove((Object) val);
            // 자식 노드들도 같이 제거해줘야 하니까
            removeChild(val);
        }
    }
}