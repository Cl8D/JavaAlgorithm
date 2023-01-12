package Programmers.Level2;

import java.util.*;

// 영어 끝말잇기
class EnglishGame {
    private static int[] answer = new int[2];

    public int[] solution(int n, String[] words) {

        List<String> storage = new ArrayList<>();
        Character prev = words[0].charAt(words[0].length()-1);
        storage.add(words[0]);

        int totalOrder = 1;

        for (int i=1; i<words.length; i++) {
            // 마지막으로 시작하는 단어를 안 했다면 탈락
            if (words[i].charAt(0) != prev) {
                return getResult(i, n, totalOrder);
            }
            // 이전에 했던 단어를 말했다면 탈락
            if (storage.contains(words[i])) {
                return getResult(i, n, totalOrder);
            }
            storage.add(words[i]);
            prev = words[i].charAt(words[i].length()-1);
            if ((i+1) % n == 0) {
                totalOrder++;
            }
        }

        answer[0] = answer[1] = 0;
        return answer;
    }

    private int[] getResult(int i, int n, int totalOrder) {
        int number = (i + 1) % n;
        if (number == 0) {
            number = n;
        }
        answer[0] = number;
        answer[1] = totalOrder;
        return answer;
    }
}