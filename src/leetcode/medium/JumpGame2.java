package leetcode.medium;


class JumpGame2 {
    public int jump(int[] nums) {
        // 현재 위치까지 해서 가장 멀리 이동할 수 있는 위치
        int max = 0;
        int count = 0;
        
        // 현재 위치
        int current = 0;
        for (int i=0; i<nums.length - 1; i++) {
            max = Math.max(max, nums[i] + i);
            System.out.println(max);
            
            if (i == current) {
                count++;
                current = max;
            }
        }
        
        // 2 3 1 1 4 
        // max = 2, currentMax = 0 : 한 번 점프해서 해당 위치로 이동 -> currentMax = 2
        // max = 4, currentMax = 2
        // max.= 4, currentMax = 2 : 한 번 점프해서 해당 위치로 이동 -> currentMax = 4 (이미 이동 완료?)
        // max = 4, currentMax = 4 
        
        return count;
    }
}
