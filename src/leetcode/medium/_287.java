package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

// 287. Find the Duplicate Number
class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int num : nums) {
            set.add(num);
            count++;
            if (set.size() != count) {
                return num;
            }
        }
        return -1;
    }
}
