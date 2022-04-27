package Inflearn.dfs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 8. 수열 추측하기
public class _0808 {
    static int[][] dp;
    static int[] val;
    static boolean[] visited;
    static int n, f;
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        // 1~n까지의 숫자
        n = Integer.parseInt(stk.nextToken());
        // 가장 밑의 줄에 있는 숫자
        f = Integer.parseInt(stk.nextToken());

        dp = new int[10][10];

        // 사실 문제 자체는 이항계수를 사용하면 금방 풀린다.
        // 가장 첫 번째 줄이 3 1 2 4라면, 최종 숫자 16의 경우
        // 3*3c0 + 1*3c1 + 2*3c2 + 4*3C1로 푸는 형식!

        val = new int[n];
        visited = new boolean[n+1];

        dfs(0);

    }

    static void dfs(int v) {
        if(check)
            return;
        if(v==n) {
            int result = 0;
            for(int i=0; i<n; i++) {
                result += val[i] * combination(n-1, i);
            }

            if(result == f) {
                for(int value: val)
                    System.out.print(value+" ");
                check = true;
            }

        } else {
            for(int i=1; i<=n; i++){
                if(!visited[i]) {
                    visited[i] = true;
                    val[v] = i;
                    dfs(v+1);
                    visited[i] = false;
                }
            }
        }

    }

    static int combination(int m, int r) {
        if(m==r || r==0) {
            return 1;
        }
        if(dp[m][r] > 0)
            return dp[m][r];

        else {
            return dp[m][r] = combination(m-1, r-1) + combination(m-1, r);
        }
    }

}