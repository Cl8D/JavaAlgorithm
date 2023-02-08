package Programmers.Level1;

import java.util.*;
import java.util.regex.Pattern;

// 숫자 짝꿍
class NumberPartner {
    private static final int MAX = 10;
    public String solution(String X, String Y) {
        StringBuilder ansBuilder = new StringBuilder("");

        int[] xArr = new int[MAX];
        int[] yArr = new int[MAX];

        for (String str : X.split("")) {
            int value = Integer.parseInt(str);
            xArr[value]++;
        }

        for (String str : Y.split("")) {
            int value = Integer.parseInt(str);
            yArr[value]++;
        }

        for (int i=MAX-1; i>=0; i--) {
            int count = Math.min(xArr[i], yArr[i]);
            ansBuilder.append(String.valueOf(i).repeat(count));
        }

        String answer = ansBuilder.toString();
        if (answer.equals("")) {
            return "-1";
        }

        if (Pattern.matches("[0]+", answer)) {
            return "0";
        }

        return answer;
    }
}