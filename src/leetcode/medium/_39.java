package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 39. Combination Sum
class _39 {
    private int[] arr;
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        arr = candidates;
        Arrays.sort(arr);

        dfs(0, target, new ArrayList<>());
        return answer;
    }

    private void dfs(int start, int target, List<Integer> list) {
        if (target == 0) {
            answer.add(new ArrayList<>(list));
        }

        for (int i = start; i < arr.length; i++) {
            if (arr[i] > target){
                break;
            }
            list.add(arr[i]);
            dfs(i, target - arr[i], list);
            list.remove(list.size() - 1);
        }
    }
}
