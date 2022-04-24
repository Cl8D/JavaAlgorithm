package Inflearn.dfs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2. 바둑이 승차 (dfs)
public class _0802 {
    static int[] weight;
    static boolean[] visited;
    static int n, c, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(buf.readLine());

        // 트럭 최대 무게
        c = Integer.parseInt(stk.nextToken());

        // 바둑이 수
        n = Integer.parseInt(stk.nextToken());

        weight = new int[n];
        visited = new boolean[n];

        for(int i=0; i<n; i++)
            weight[i] = Integer.parseInt(buf.readLine());

        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int val) {
        if(val == n) {
            int temp = 0;
            for(int i=0; i<n; i++) {
                if(visited[i]) {
                    temp += weight[i];
                }
            }

            if(temp <= c && temp > answer)
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