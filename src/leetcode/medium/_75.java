package leetcode.medium;

// 75. Sort Colors
class _75 {
    public void sortColors(int[] nums) {
        // 0은 앞쪽에, 2는 뒤쪽으로 위치하도록 만들기
        // 아이디어가 정말 좋은 문제인 것 같다!
        int zero = 0, two = nums.length - 1;
        int current = 0;
        while (current <= two) {
            if (nums[current] == 0) {
                swap(nums, current, zero);
                current++;
                zero++;
            } else if (nums[current] == 2) {
                swap(nums, current, two);
                two--;
            } else {
                current++;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
