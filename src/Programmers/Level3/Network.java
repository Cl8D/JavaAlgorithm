package Programmers.Level3;

import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

// 네트워크
class Network {
    public int solution(int n, int[][] computers) {
        List<Integer>[] networks = new ArrayList[n];
        for (int i = 0; i<n; i++) {
            networks[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && computers[i][j] == 1) {
                    networks[i].add(j);
                }
            }
        }

        int answer = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> list = networks[i];
            for (int value: list) {
                if (!visited[value]) {
                    queue.add(value);
                }
            }

            if (!queue.isEmpty() || list.size() == 0) {
                answer++;
            }

            while (!queue.isEmpty()) {
                int current = queue.poll();
                visited[current] = true;

                List<Integer> child = networks[current];
                for (int value: child) {
                    if (!visited[value]) {
                        queue.add(value);
                    }
                }
            }
        }


        return answer;
    }
}
