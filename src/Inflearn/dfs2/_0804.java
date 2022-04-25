package Inflearn.dfs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 4. 중복 순열
public class _0804 {
    static int n, m;
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        // 1~n까지 적힌 구슬에서 중복 허락, m번 뽑아서 일렬 나열
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        check = new int[m];
        dfs(0);
    }

    static void dfs(int v) {
        if(v==m) {
            for(int c : check)
                System.out.print(c + " ");
            System.out.println();
        }
        else {
            for(int i=1; i<=n; i++) {
                check[v] = i;
                dfs(v+1);
            }
        }

    }
    /*
        - dfs(0)
    check[0] = 1 // 30

    - dfs(1)
    check[1] = 1 // 30

    - dfs(2) => 출력) 1, 1 => 종료

    - dfs(1)
    check[1] = 2 // 30

    - dfs(2) => 출력) 1, 2 => 종료

    - dfs(1)
    check[1 = 3 // 30

    - dfs(2) => 출력) 1, 3 => 종료

    - dfs(0)
    check[0] = 2 // 30

    - dfs(1)
    check[1] = 1 // 30

    - dfs(2) => 출력) 2, 1 => 종료

    ... 반복
     */

}