package Inflearn.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 12. 그래프 최단거리 (BFS)
public class _0712 {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(buf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        graph = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<Integer>());

        visited = new boolean[n+1];
        distance = new int[n+1];

        for(int i=0; i<m; i++) {
            stk = new StringTokenizer(buf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            graph.get(a).add(b);
        }

        bfs(1);

        for(int i=2; i<=n; i++)
            System.out.println(i + " : " + distance[i]);
    }

    static void bfs(int v) {
        visited[v] = true;
        distance[v] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int vertex : graph.get(current)) {
                if(visited[vertex] == false) {
                    visited[vertex]= true;
                    queue.add(vertex);
                    distance[vertex] = distance[current]+1;
                }
            }

        }
    }

}