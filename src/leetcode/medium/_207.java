package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 207. Course Schedule
class _207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 선수 과목 문제 -> 위상 정렬 활용하기
        List<Integer>[] list = new ArrayList[numCourses];
        for (int i=0; i<numCourses; i++) {
            list[i] = new ArrayList<>();
        }

        int[] orders = new int[numCourses];
        boolean[] visited = new boolean[numCourses];

        for (int[] prerequisite : prerequisites) {
            int first = prerequisite[0];
            int last = prerequisite[1];
            list[first].add(last);
            orders[last]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<orders.length; i++) {
            if (orders[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int targetCourse = queue.poll();
            visited[targetCourse] = true;
            List<Integer> linkedCourses = list[targetCourse];
            for (int linkedCourse : linkedCourses) {
                orders[linkedCourse]--;
                if (orders[linkedCourse] == 0) {
                    queue.add(linkedCourse);
                }
            }
        }

        for (boolean visit : visited) {
            if (!visit) {
                return false;
            }
        }
        return true;
    }
}

