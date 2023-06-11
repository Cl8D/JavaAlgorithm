package leetcode.medium;

import java.util.Arrays;

// 31. Next Permutation
class _31 {

    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int target = 0;
        boolean isChanged = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                target = i;
                isChanged = true;
            }
        }

        if (!isChanged) {
            Arrays.sort(nums);
            return;
        }

        // 자리바꿀 대상 구하기, target보다 크면서 가장 작은 숫자 
        int nextTarget = nums.length - 1;
        for (int i = nums.length - 1; i > target; i--) {
            if (nums[i] > nums[target]) {
                nextTarget = i;
                break;
            }
        }

        swap(nums, target, nextTarget);

        // 자리 바꾸고 나서 target+1부터 배열의 끝까지 오름차순으로 정렬하기
        reverse(nums, target + 1);
    }

    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    private void reverse(int[] nums, int target) {
        int i = target;
        int j = nums.length - 1;

        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}

/**
 * 최적의 풀이 - 이렇게 푸는 게 훨씬 좋다... 접근 방식은 똑같은데 코드의 차이인 듯!
 **/
/**
class Solution {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}

**/
