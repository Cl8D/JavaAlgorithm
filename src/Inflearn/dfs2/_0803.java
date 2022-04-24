package Inflearn.dfs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3. 최대점수 구하기 (DFS)
public class _0803 {
    static int n, m, answer;
    static int[][] score;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());

        // 문제 개수
        n = Integer.parseInt(stk.nextToken());
        // 제한 시간
        m = Integer.parseInt(stk.nextToken());

        score = new int[n][2];
        visited = new boolean[n];

        for(int i=0; i<n; i++) {
            stk = new StringTokenizer(buf.readLine());
            // 점수
            int a = Integer.parseInt(stk.nextToken());
            // 걸리는 시간
            int b = Integer.parseInt(stk.nextToken());

            score[i][0] = a;
            score[i][1] = b;
        }

        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int val) {
        if(val == n) {
            int time = 0;
            int temp = 0;
            for(int i=0; i<visited.length; i++) {
                if(visited[i]) {
                    time += score[i][1];
                    temp += score[i][0];
                }
            }

            if(time <= m && temp > answer)
                answer = temp;
        }
        else {
            visited[val] = true;
            dfs(val+1);
            visited[val] = false;
            dfs(val+1);
        }
    }
}