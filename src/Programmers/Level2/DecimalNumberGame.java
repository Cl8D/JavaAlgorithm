package Programmers.Level2;

import java.util.*;

// n진수 게임
class DecimalNumberGame {
    public String solution(int n, int t, int m, int p) {
        String answer = "";

        int number = 0, order = p, count = 0;

        while(true) {
            String transNumber = Integer.toString(number++, n);
            for (String num : transNumber.split("")) {
                count++;
                if (answer.length() == t) {
                    return answer;
                }
                if (count == order) {
                    answer += Character.toUpperCase(num.charAt(0));
                    order += m;
                }
            }
        }
    }
}