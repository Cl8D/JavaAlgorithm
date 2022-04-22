package Inflearn.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 11. 경로 탐색 (인접리스트)
// 인접리스트의 장점 -> 인접행렬에 비해 조금 더 메모리를 덜 잡아먹는다.
// 인접행렬의 경우 nxn을 만들어야 해서 n이 커지면 메모리를 너무 많이 사용하게 된다.
public class _0711 {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int n;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<Integer>());

        visited = new boolean[n+1];

        for(int i=0; i<m; i++) {
            stk = new StringTokenizer(buf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            graph.get(a).add(b);
        }
        visited[1] = true;
        dfs(1);
        System.out.println(answer);
    }

    static void dfs(int v) {
        if(v==n) {
            answer++;
        }
        else {
            for(int i=0; i<graph.get(v).size(); i++) {
                if(visited[graph.get(v).get(i)] == false) {
                    visited[graph.get(v).get(i)] = true;
                    dfs(graph.get(v).get(i));
                    visited[graph.get(v).get(i)] = false;
                }
            }
        }
    }
}

