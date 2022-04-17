package Inflearn.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3. 팩토리얼
public class _0703 {
    static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(buf.readLine());
        dfs(n);
        System.out.println(answer);
    }

    static void dfs(int n) {
        if(n==0)
            return;
        else {
            dfs(n-1);
            answer *= n;
        }
    }
}
