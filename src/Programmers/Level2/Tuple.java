package Programmers.Level2;

import java.util.*;

// 튜플
class Tuple {
    private static final Map<String, Integer> map = new HashMap<>();

    public int[] solution(String s) {
        // 처음과 끝의 {} 제거
        s = s.substring(1, s.length()-1);

        // }를 기준으로 튜플 분리
        String[] tuples = s.split("}");

        for(String tuple : tuples) {
            // 튜플에 대한 전처리 진행해주기
            tuple = tuple.replace(",{", "");
            tuple = tuple.replace("{", "");
            addValue(tuple);
        }

        List<String> keys = new ArrayList<>(map.keySet());
        keys.sort((o1, o2) -> map.get(o2) - map.get(o1));

        int[] answer = new int[keys.size()];
        int answerIdx = 0;
        for (String key : keys) {
            answer[answerIdx++] = Integer.parseInt(key);
        }

        return answer;
    }

    private void addValue(String s) {
        String[] strs = s.split(",");
        for (String str : strs) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
    }
}