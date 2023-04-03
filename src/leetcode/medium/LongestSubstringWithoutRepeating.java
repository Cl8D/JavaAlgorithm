package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int answer = 0;

        while (right < s.length()) {
            char target = s.charAt(right);

            // 중복된 문자가 존재할 경우 -> 시작 위치를 이전에 존재하던 문자 다음으로 이동
            if (map.containsKey(target)) {
                left = Math.max(left, map.get(target) + 1);
            }
            map.put(target, right);
            answer = Math.max(answer, right - left + 1);
            right++;
        }
        return answer;
    }
}
