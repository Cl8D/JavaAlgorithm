package Programmers.Level2;

import java.util.*;

// 괄호 변환
class BracketConversion {
    public String solution(String p) {
        return recur(p);
    }

    private String recur(String str) {
        // 입력이 빈 문자열이라면, 빈 문자열을 반환한다.
        if (str.equals("")) {
            return "";
        }

        // 처음부터 올바른 괄호 문자열이 주어졌을 경우 그대로 리턴한다.
        if (checkBalancedStr(str) && checkRightStr(str)) {
            return str;
        }

        // 균형잡힌 괄호 문자열 2개로 분해하기.
        SplitStr splitStr = splitToBalancedStr(str);
        String u = splitStr.u;
        String v = splitStr.v;

        // u가 올바른 괄호 문자열이라면 v에 대해 재수행
        if (checkRightStr(u)) {
            String result = recur(v);
            // 이 시점의 u에 반환된 문자열을 이어붙여준다.
            return u + result;
        }

        // 아니라면 새로운 문자열을 생성한다.
        StringBuilder temp = new StringBuilder("");

        // v에 대해서 재귀적으로 수행한다. << 이 부분 때문에 시간 소비함...
        v = recur(v);

        temp.append("(").append(v).append(")");

        // u의 첫 번째와 마지막 문자 제거
        StringBuilder uTemp = new StringBuilder(u);
        uTemp = uTemp.deleteCharAt(0);
        uTemp = uTemp.deleteCharAt(uTemp.length()-1);

        // 나머지 문자열의 괄호방향을 뒤집어서 붙이기
        u = uTemp.toString();
        u = u.replaceAll("\\(", "a");
        u = u.replaceAll("\\)", "b");
        u = u.replaceAll("a", ")");
        u = u.replaceAll("b", "(");
        temp.append(u);

        return temp.toString();
    }


    // 균형잡힌 문자열 2개로 나누기
    private SplitStr splitToBalancedStr(String str) {
        String u = str, v = "";

        for (int i=0; i<str.length(); i++) {
            String tempU = str.substring(0, i);
            String tempV = str.substring(i, str.length());
            if (checkBalancedStr(tempU) && checkBalancedStr(tempV)) {
                u = tempU;
                v = tempV;
                break;
            }
        }
        return new SplitStr(u, v);
    }

    // 균형잡힌 괄호 문자열인지 체크한다.
    private boolean checkBalancedStr(String str) {
        String left = str.replaceAll("\\(", "");
        String right = str.replaceAll("\\)", "");
        int leftCount = str.length() - right.length();
        int rightCount = str.length() - left.length();
        if (leftCount > 0 && rightCount > 0 && leftCount == rightCount) {
            return true;
        }
        return false;
    }

    // 올바른 괄호 문자열인지 체크한다.
    private boolean checkRightStr(String str) {
        Stack<Character> stack = new Stack<>();
        for (Character ch : str.toCharArray()) {
            if (ch == '(') {
                stack.add(ch);
                continue;
            }
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    static class SplitStr {
        String u;
        String v;

        public SplitStr(String u, String v) {
            this.u = u;
            this.v = v;
        }

        @Override
        public String toString() {
            return "u = " + u + " v = " + v;
        }
    }
}