package Programmers.Level1;

import java.util.*;

// 성격 유형 계산하기
class CheckCharacterType {
    static Map<Character, Integer> result = new HashMap<>();
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder("");

        // survey : 질문마다 판단하는 지표
        // 각 원소는 길이가 2인 String으로 이루어져 있으며, 첫 번째는 비동의, 두 번째는 동의 선택지를 선택하면 받는 성격 유형이다.
        // choices : 검사자가 선택한 i+1번째 질문의 선택지이다.
        init();

        // 1 2 3 4 5 6 7
        // 3 2 1 0 1 2 3
        final int standardNum = 4;
        for (int i=0; i<choices.length; i++) {
            int choice = choices[i];
            String type = survey[i];
            Character disagree = type.charAt(0);
            Character agree = type.charAt(1);

            // 모르겠음 이후의 선택지를 골랐을 경우
            if (choice > standardNum) {
                result.put(agree, result.get(agree) + (choice - standardNum));
                continue;
            }
            result.put(disagree, result.get(disagree) + (standardNum - choice));
        }
        answer.append(compare('R', 'T'));
        answer.append(compare('C', 'F'));
        answer.append(compare('J', 'M'));
        answer.append(compare('A', 'N'));

        return answer.toString();
    }

    private Character compare(Character firstType, Character secondType) {
        int firstVal = result.get(firstType);
        int secondVal = result.get(secondType);

        if (firstVal < secondVal) {
            return secondType;
        }
        if (firstVal > secondVal) {
            return firstType;
        }

        // 사전순으로 더 빠른 값 리턴
        if (firstType - secondType < 0) {
            return firstType;
        }
        return secondType;
    }

    private void init() {
        result.put('A', 0);
        result.put('N', 0);
        result.put('C', 0);
        result.put('F', 0);
        result.put('M', 0);
        result.put('J', 0);
        result.put('R', 0);
        result.put('T', 0);
    }
}