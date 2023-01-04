package Programmers.Level2;

import java.util.*;

// 압축
class Compress {

    public static void main(String[] args) {
        int[] answer = solution("KAKAO");
        System.out.println(Arrays.toString(answer));
    }
    private static final Map<String, Integer> indexes = new HashMap<>();

    public static int[] solution(String msg) {
        int[] answer = {};
        initIndex();

        List<Integer> tempAns = new ArrayList<>();

        String[] msgs = msg.split("");
        int lastIndex = 26;
        boolean flag = false;

        for (int i = 0; i < msgs.length; i++) {
            String value = msgs[i];

            // 글자가 사전에 없을 때까지 반복한다.
            while (indexes.containsKey(value)) {
                // 다음 글자를 뽑기 위해 인덱스를 증가시킨다.
                i++;
                // 마지막에 도달했을 경우를 체크한다.
                if (i == msg.length()) {
                    flag = true;
                    break;
                }
                value += msgs[i];
            }

            /// 마지막으로 처리되지 않은 글자에 대해서는 별도로 처리해준다.
            if (flag) {
                tempAns.add(indexes.get(value));
                break;
            }

            // 이전의 문자열에 대해서 출력해준다 (정답 리스트에 담기)
            String compress = value.substring(0, value.length() - 1);
            tempAns.add(indexes.get(compress));
            // 다음 글자를 포함하여 새롭게 만들어진 문자에 대해서 사전에 넣는다.
            indexes.put(value, ++lastIndex);

            // 다음 글자를 뽑기 위해 증가시킨 인덱스를 다시 감소시킨다.
            i--;
        }

        answer = new int[tempAns.size()];
        int answerIdx = 0;
        for (int ans : tempAns) {
            answer[answerIdx++] = ans;
        }

        return answer;
    }

    private static void initIndex() {
        // A -> 65 (아스키)
        for (int i=0; i<26; i++) {
            char value = (char)(65 + i);
            indexes.put(String.valueOf(value), i+1);
        }
    }
}