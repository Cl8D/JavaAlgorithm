package Programmers.Level1;

import java.util.Map;
import java.util.HashMap;

// 가장 가까운 작은 글자
class TheBestClosestWord {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (map.containsKey(ch)) {
                answer[i] = i - map.get(ch);
            } else {
                answer[i] = -1;
            }

            map.put(ch, i);
        }

        return answer;
    }
}