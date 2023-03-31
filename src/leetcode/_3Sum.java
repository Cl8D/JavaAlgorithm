package leetcode;

import java.util.*;

// 3Sum
class _3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int sum = nums[i];
            int start = i + 1, end = n - 1;

            while (start < end) {
                sum += (nums[start] + nums[end]);
                if (sum < 0) {
                    sum = nums[i];
                    start++;
                } else if (sum == 0) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[start], nums[end]);
                    if (!answer.contains(temp)) {
                        answer.add(temp);
                    }
                    start++;
                } else {
                    sum = nums[i];
                    end--;
                }
            }
        }

        return answer;
    }
}
