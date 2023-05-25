package leetcode.medium;

import java.util.*;

// 128. Longest Consecutive Sequence
class _128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int answer = 1;
        Arrays.sort(nums);
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]) {
                continue;
            }
            if (nums[i-1] + 1 == nums[i]) {
                count++;
            } else {
                answer = Math.max(answer, count);
                count = 1;
            }
        }

        answer = Math.max(answer, count);
        return answer;
    }
}
