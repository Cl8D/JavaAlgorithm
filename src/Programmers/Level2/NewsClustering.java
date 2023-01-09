package Programmers.Level2;

import java.util.*;

// [1차] 뉴스 클러스터링
class NewsClustering {
    private static final Map<String, Integer> strOnes = new HashMap<>();
    private static final Map<String, Integer> strTwos = new HashMap<>();
    private static final int VALUE = 65536;

    public int solution(String str1, String str2) {
        int answer = 0;

        // 자카드 유사도 = 교집합 원소의 개수 / 합집합 원소의 개수
        // 둘 다 공집합이면 1로 정의
        // 이때, 다중집합으로 확장하여 동일한 원소에 대해서 
        // 교집합은 min(a,b) 합집합은 max(a,b)로 정의한다.
        // 문자열은 2개씩 끊어서 다중집합을 생성한다.


        for (int i=0; i<str1.length()-1; i++) {
            String newStr = String.valueOf(str1.charAt(i)) + String.valueOf(str1.charAt(i+1));
            String postStr = newStr.replaceAll("[^a-zA-Z]", "").toUpperCase();
            if (newStr.length() != postStr.length()) {
                continue;
            }
            strOnes.put(postStr, strOnes.getOrDefault(postStr, 0) + 1);
        }

        for (int i=0; i<str2.length()-1; i++) {
            String newStr = String.valueOf(str2.charAt(i)) + String.valueOf(str2.charAt(i+1));
            String postStr = newStr.replaceAll("[^a-zA-Z]", "").toUpperCase();
            if (newStr.length() != postStr.length()) {
                continue;
            }
            strTwos.put(postStr, strTwos.getOrDefault(postStr, 0) + 1);
        }

        List<String> min = new ArrayList<>();
        List<String> max = new ArrayList<>();

        // str1에 대해서 계산하기.
        for (String key : strOnes.keySet()) {
            // str2에 포함되지 않았으면 합집합으로 넣어준다.
            if (!strTwos.containsKey(key) && !max.contains(key)) {
                int cnt = strOnes.get(key);
                addValue(key, cnt, max);
                continue;
            }

            // 포함된 경우에는 값을 비교해서 넣어준다.
            int minCnt = Math.min(strOnes.get(key), strTwos.get(key));
            if (!min.contains(key)) {
                addValue(key, minCnt, min);
            }

            int maxCnt = Math.max(strOnes.get(key), strTwos.get(key));
            if (!max.contains(key)) {
                addValue(key, maxCnt, max);
            }
            // str2에서 제거해준다.
            strTwos.remove(key);
        }

        // str2에 대해서도 계산. str2에서만 존재하는 문자열이 남아있게 된다.
        for (String key : strTwos.keySet()) {
            int cnt = strTwos.get(key);
            if (!max.contains(key)) {
                addValue(key, cnt, max);
            }
        }

        int inter = min.size();
        int sum = max.size();

        if (min.size() == 0 && max.size() == 0) {
            return VALUE;
        }

        double result = ((double) inter / sum) * 65536;
        return (int) Math.floor(result);
    }

    private void addValue(String key, int cnt, List<String> list) {
        for (int i=0; i<cnt; i++) {
            list.add(key);
        }
    }
}