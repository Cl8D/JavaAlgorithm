package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 33. Search In Rotated Sorted Array
class _33 {
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

/**
 * 그 외에 이런 식으로도 푸는 방법이 있다.
 */

/**
public int search(int[] nums, int target) {
    // Creating ArrayList
    ArrayList<Integer> clist = new ArrayList<>();

    // adding elements of array
    // to ArrayList
    for (int i : nums)
        clist.add(i);

    // returning index of the element
    return clist.indexOf(target);
}
*/

/**
public int search(int[] nums, int target) {
    int size = nums.length;
    int i =0;
    int j = size-1;
    while(i<=j){
        if(nums[i]==target){
            return i;
        }
        else if(nums[j]==target){
            return j;
        }
        else if(nums[i]+nums[j]>target){
            j--;
        }
        else if(nums[i]+nums[j]<target){
            i++;
        }
        else if(nums[i]+nums[j]==target){
            i++;
            j--;
        }
    }

    return -1;
}
*/
