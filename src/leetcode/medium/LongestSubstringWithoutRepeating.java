package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        // 마지막으로 등장한 인덱스 저장
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int answer = 0;

        while (right < s.length()) {
            char target = s.charAt(right);

            // 중복된 문자가 존재할 경우 -> 시작 위치를 이전에 존재하던 문자 다음으로 이동
            // (이미 이전에 존재하는 중복되지 않은 문자열 다음부터 탐색하기 위해)
            if (map.containsKey(target)) {
                // left -> 현재 부분 문자열의 시작 인덱스
                left = Math.max(left, map.get(target) + 1);
            }
            map.put(target, right);
            // right -> 현재 부분 문자열의 마지막 인덱스
            answer = Math.max(answer, right - left + 1);
            right++;
        }
        return answer;
    }
}
