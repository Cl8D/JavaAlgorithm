package Inflearn.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 4. 피보나치 재귀
public class _0704 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(buf.readLine());
        for(int i=1; i<=n; i++)
            System.out.print(dfs(i) + " ");
    }

    static int dfs(int depth) {
        if(depth == 1 || depth == 2) {
            return 1;
        }
        else
            return dfs(depth-1) + dfs(depth-2);
    }
}
