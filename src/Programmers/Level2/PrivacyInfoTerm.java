package Programmers.Level2;

import java.util.*;

// 개인정보 수집 유효기간
class PrivacyInfoTerm {
    private static int curYear = 0, curMonth = 0, curDay = 0;
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};

        // 정규식 주의!!
        String[] todays = today.split("\\.");
        curYear = strToInt(todays[0]);
        curMonth = strToInt(todays[1]);
        curDay = strToInt(todays[2]);

        // 단위는 달.
        Map<String, Integer> rule = new HashMap<>();
        for (String term : terms) {
            String[] arr = term.split(" ");
            rule.put(arr[0], Integer.parseInt(arr[1]));
        }

        List<Integer> result = new ArrayList<>();

        for (int i=0; i<privacies.length; i++) {
            String privacy = privacies[i];
            String[] arr = privacy.split(" ");
            String date = arr[0];
            String term = arr[1];
            int month = rule.get(term);

            if(addDate(date, month)) {
                result.add(i+1);
            }
        }

        answer = new int[result.size()];
        int idx = 0;
        for (int val : result) {
            answer[idx++] = val;
        }
        return answer;
    }

    private boolean addDate(String date, int value) {
        String[] arr = date.split("\\.");
        int year = strToInt(arr[0]);
        int month = strToInt(arr[1]);
        int day = strToInt(arr[2]);

        int newMonth = month + value;

        // 기간의 범위가 커서 여기서 반복문 돌려줘야 한다.
        while(newMonth > 12) {
            year++;
            newMonth -= 12;
        }

        if (curYear < year || (curYear == year && curMonth < newMonth) ||
                (curYear == year && curMonth == newMonth && curDay < day)) {
            return false;
        }

        return true;
    }

    private int strToInt(String str) {
        return Integer.parseInt(str);
    }
}