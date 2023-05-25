package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 49. Group Anagrams
class _49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> values = map.getOrDefault(key, new ArrayList<>());
            values.add(str);
            map.put(key, values);
        }

        List<List<String>> answer = new ArrayList<>();
        for (String key : map.keySet()) {
            List<String> values = map.get(key);
            answer.add(values);
        }
        return answer;
    }
}
