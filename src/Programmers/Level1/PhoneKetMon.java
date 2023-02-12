package Programmers.Level1;

import java.util.*;

// 폰켓몬
class PhoneKetMon {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return Math.min(set.size(), nums.length / 2);
    }
}