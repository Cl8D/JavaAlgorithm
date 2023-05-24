package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 33. Search In Rotated Sorted Array
class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        Arrays.sort(nums);

        int start = 0, end = nums.length - 1;
        int answer = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2;
            int midVal = nums[mid];

            if (midVal == target) {
                answer = midVal;
                break;
            }
            if (midVal > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (answer == Integer.MAX_VALUE) {
            return -1;
        }

        return map.get(answer);
    }
}
