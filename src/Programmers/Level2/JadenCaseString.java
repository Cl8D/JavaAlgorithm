package Programmers.Level2;

import java.util.*;

// JasonCase 문자열 만들기
class JadenCaseString {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder("");

        boolean flag = false;
        for (int i=0; i<s.length(); i++) {
            if (i==0) {
                answer.append(Character.toUpperCase(s.charAt(0)));
                continue;
            }

            if (s.charAt(i) == ' ') {
                answer.append(" ");
                flag = true;
                continue;
            }

            if (flag) {
                answer.append(Character.toUpperCase(s.charAt(i)));
                flag = false;
                continue;
            }
            answer.append(Character.toLowerCase(s.charAt(i)));

        }

        return answer.toString();
    }
}