package Programmers.Level2;

import java.util.*;

// 카펫
class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int width = yellow + 2, height = 3;
        int round = calculateRound(width, height);
        int divVal = 2;

        while (round != brown) {
            if (yellow % divVal != 0) {
                divVal++;
                continue;
            }

            width = yellow / divVal + 2;
            height = divVal + 2;
            round = calculateRound(width, height);
            divVal++;
        }

        answer[0] = width;
        answer[1] = height;

        return answer;
    }

    private int calculateRound(int w, int h) {
        return 2 * w + 2 * h - 4;
    }
}