package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 34. Find First and Last Position of Element in Sorted Array
class _34 {
    public int[] searchRange(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i<nums.length; i++) {
            List<Integer> value = map.getOrDefault(nums[i], new ArrayList<>());
            value.add(i);
            map.put(nums[i], value);
        }


        int start = 0, end = nums.length - 1;
        boolean isExist = false;

        while (start <= end) {
            int mid = (start + end) / 2;
            int midVal = nums[mid];
            if (midVal == target) {
                isExist = true;
                break;
            }

            if (midVal < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (!isExist) {
            return new int[]{-1, -1};
        }

        int[] result = new int[2];
        List<Integer> indexes = map.get(target);
        result[0] = indexes.get(0);
        result[1] = indexes.get(indexes.size() - 1);
        return result;

    }
}
