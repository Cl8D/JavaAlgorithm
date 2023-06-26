package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// 78. Subsets
class _78 {
    private List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, new ArrayList<>(), 0);
        return answer;
    }

    private void dfs(int[] nums, List<Integer> temp, int start) {
        // 그냥 temp만 넣으면 백트래킹 때문에 사라지니까 새롭게 할당 후 넣어주기~
        answer.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(nums, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
