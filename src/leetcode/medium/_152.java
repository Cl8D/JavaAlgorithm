package leetcode.medium;

// 152. Maximum Product Subarray
class _152 {
    public int maxProduct(int[] nums) {
        int min = nums[0], max = nums[0];
        int result = max;

        for (int i=1; i<nums.length; i++) {
            int tempMax = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            int tempMin = Math.min(nums[i], Math.min(min * nums[i], max * nums[i]));
            result = Math.max(result, Math.max(tempMax, tempMin));
            max = tempMax;
            min = tempMin;
        }

        return result;
    }
}
