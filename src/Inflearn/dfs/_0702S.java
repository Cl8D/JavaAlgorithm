package Inflearn.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2. 이진수 출력(재귀) - 솔루션 코드
public class _0702S {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(buf.readLine());
        dfs(n);

    }
    // 11 -> 5...1 => 2... 1 => 1...0
    // => 1011
    static void dfs(int n) {
        if(n==0)
            return;
        else{
            dfs(n/2);
            System.out.print(n%2);
        }
    }
}
