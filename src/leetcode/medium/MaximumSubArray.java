package leetcode.medium;

// 53. Maximum Subarray
class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        // 카데인 알고리즘
        int[] dp = new int[nums.length];
        dp[0] = nums[0];


        int max = dp[0];
        for (int i =1; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
