package BOJ.Silver.Silver4;

import java.io.*;
import java.util.*;

// 카드 뽑기
public class _5568 {
    static boolean[] visited;
    static int n, k;
    static int[] val;
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        n = Integer.parseInt(buf.readLine());
        k = Integer.parseInt(buf.readLine());

        visited = new boolean[n];
        val = new int[n];
        for(int i=0; i<n; i++)
            val[i] = Integer.parseInt(buf.readLine());

        set = new HashSet<>();
        recur(0, "");

        buf2.write(set.size() + "");
        buf2.flush();
        buf.close();
        buf2.close();

    }

    static void recur(int depth, String str) {
        if(depth==k) {
            set.add(Integer.parseInt(str));
            return;
        }

        for (int i = 0; i < n; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            recur(depth+1, str + val[i]);
            visited[i] = false;
        }

    }
}
