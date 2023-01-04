package Programmers.Level2;

import java.util.*;

// 압축
class Compress {
    private static final Map<String, Integer> indexes = new HashMap<>();

    public int[] solution(String msg) {
        int[] answer = {};
        initIndex();

        List<Integer> tempAns = new ArrayList<>();

        String[] msgs = msg.split("");
        int lastIndex = 26;
        boolean flag = false;

        for (int i = 0; i < msgs.length; i++) {
            String value = msgs[i];

            // 만약 글자가 사전에 있다면
            while (indexes.containsKey(value)) {
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

            // 압축시킨 문자열을 뽑아낸 다음에 사전에 등록한다.
            String compress = value.substring(0, value.length() - 1);
            tempAns.add(indexes.get(compress));
            indexes.put(value, ++lastIndex);
            i--;
        }

        answer = new int[tempAns.size()];
        int answerIdx = 0;
        for (int ans : tempAns) {
            answer[answerIdx++] = ans;
        }

        return answer;
    }

    private void initIndex() {
        // A -> 65 (아스키)
        for (int i=0; i<26; i++) {
            char value = (char)(65 + i);
            indexes.put(String.valueOf(value), i+1);
        }
    }
}