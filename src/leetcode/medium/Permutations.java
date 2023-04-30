package leetcode.medium;

import java.util.*;

// 46. Permutations
class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        int[] values = new int[nums.length];
        boolean[] visited = new boolean[nums.length];

        Param param = new Param(answer, values, nums, visited);
        dfs(0, nums.length, param);
        return param.answer;
    }

    private static void dfs(int depth, int n, Param param) {
        if (depth == n) {
            List<Integer> temp = new ArrayList<>();
            for (int value : param.values) {
                temp.add(value);
            }
            param.answer.add(temp);
            return;
        }

        for (int i=0; i<n; i++) {
            if (!param.visited[i]) {
                param.visited[i] = true;
                param.values[depth] = param.nums[i];
                Param newParam = new Param(param.answer, param.values, param.nums, param.visited);
                dfs(depth + 1, n, newParam);
                param.visited[i] = false;
            }
        }
    }

    private static class Param {
        List<List<Integer>> answer;
        int[] values;
        int[] nums;
        boolean[] visited;

        public Param(final List<List<Integer>> answer, final int[] values, final int[] nums, final boolean[] visited) {
            this.answer = answer;
            this.values = values;
            this.nums = nums;
            this.visited = visited;
        }
    }
}
