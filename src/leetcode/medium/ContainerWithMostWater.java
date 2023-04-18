package leetcode.medium;

// Container With Most Water
class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int answer = 0;

        while (left < right) {
            int leftVal = height[left];
            int rightVal = height[right];

            int water = Math.min(leftVal, rightVal) * (right - left);
            answer = Math.max(answer, water);


            if (leftVal < rightVal) {
                left++;
            } else {
                right--;
            }
        }

        return answer;
    }
}
