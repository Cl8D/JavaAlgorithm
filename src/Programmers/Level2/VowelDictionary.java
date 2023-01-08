package Programmers.Level2;

import java.util.*;

// 리팩토링 버전. 정렬하지 않고, 내부에서 바로 체크하는 걸로 변경했다.
class VowelDictionary2 {
    private static final String[] VOWEL = {"A", "E", "I", "O", "U"};
    private static int order = 0;
    private static boolean flag = false;

    public int solution(String word) {
        StringBuilder result = new StringBuilder();
        return recur(result, word);
    }

    // 너무 level 관련 풀이에 집착했던 것 같아서 반성...
    private int recur(StringBuilder result, String word) {
        if (word.equals(result.toString())) {
            // 정답인 경우 여기서 전역 플래그를 true로 설정.
            flag = true;
            return order;
        }

        // 최대 길이를 넘었을 경우 리턴. (이 조건이 중요하다. 아니면 무한루프 걸림)
        if (result.length() == 5) {
            return order;
        }

        for(String value : VOWEL) {
            result.append(value);
            order++;
            recur(result, word);

            // 전역 플래그 체크.
            if (flag) {
                return order;
            }
            result.deleteCharAt(result.length()-1);
        }

        return order;
    }
}

// 모음 사전 -> 내가 푼 풀이이긴 한데 정렬까지 들어가면서 비효율적이다.
class VowelDictionary {
    private static final String[] VOWEL = {"A", "E", "I", "O", "U"};
    private static final List<String> words = new ArrayList<>();

    public int solution(String word) {
        int answer = 0;
        for (int i=1; i<=5; i++) {
            StringBuilder result = new StringBuilder();
            recur(0, i, result);
        }

        words.sort(Comparator.naturalOrder());

        for (int i=0; i<words.size(); i++) {
            if (words.get(i).equals(word)) {
                return i+1;
            }
        }

        return answer;
    }

    private void recur(int level, int n, StringBuilder result) {
        if (level == n) {
            words.add(result.toString());
            return;
        }

        for(String value : VOWEL) {
            result.append(value);
            recur(level+1, n, result);
            result.deleteCharAt(result.length()-1);
        }
    }
}