package BOJ.Silver.Silver2;

import java.io.*;
import java.util.*;

// 촌수계산
public class _2644 {
    static int n, a, b, ans=0;
    static List<Integer>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        n = Integer.parseInt(buf.readLine());
        stk = new StringTokenizer(buf.readLine());
        a = Integer.parseInt(stk.nextToken());
        b = Integer.parseInt(stk.nextToken());

        tree = new ArrayList[n+1];

        for(int i=1; i<=n; i++)
            tree[i] = new ArrayList<>();

        int m = Integer.parseInt(buf.readLine());
        for(int i=0; i<m; i++) {
            stk = new StringTokenizer(buf.readLine());
            int v1 = Integer.parseInt(stk.nextToken());
            int v2 = Integer.parseInt(stk.nextToken());
            tree[v1].add(v2);
            tree[v2].add(v1);
        }

        visited = new boolean[n+1];
        dfs(a, 1);

        if(ans==0)
            ans = -1;

        buf2.write(ans + "");
        buf2.flush();
        buf.close();
        buf2.close();

    }

    static void dfs(int idx, int depth) {
        for(int val : tree[idx]) {
            if(!visited[val]) {
                if(val == b)
                    ans = depth;
                visited[val] = true;
                dfs(val, depth+1);
            }
        }
    }
}
