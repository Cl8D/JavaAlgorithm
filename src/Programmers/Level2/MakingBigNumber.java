package Programmers.Level2;

import java.util.*;

// 큰 수 만들기
class MakingBigNumber {
    // ref) https://born2bedeveloper.tistory.com/27

    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder("");
        // 어차피 정답은 가장 큰 수를 구하는 것이기 때문에, 맨 앞자리 수가 가장 큰 수가 되어야 한다.
        // 또한, number.length() - k의 길이를 만족하도록 해야 된다.

        // 뒤에서부터 뽑아야 되는 숫자의 길이-1개를 남겨둔다. (길이 보장)
        // 남은 숫자 중에 가장 큰 수를 정답에 붙이고 해당 수의 앞에 있는 숫자들은 제거한다. (순서 보장)
        // 뒤에서부터 뽑아야 되는 숫자의 길이-2개를 남겨둔다. (1개 뽑았으니까)
        // 다시 큰 수 붙이고, 앞에 있는 거 제거하는 방식으로 진행한다,
        // 위의 로직을 반복한다.

        int length = number.length() - k;
        int start = 0;

        while (start < number.length() && answer.length() != length) {
            // 인덱스로 따지면 뽑아야 되는 숫자의 길이 + 현재 답 길이 + 1가 마지막 인덱스의 값이 된다.
            int leftNum = k + answer.length() + 1;

            // 남은 숫자 중에 가장 큰 수를 붙여주는 작업.
            int maxVal = 0;
            for(int i=start; i<leftNum; i++) {
                if (maxVal < Character.getNumericValue(number.charAt(i))) {
                    maxVal = Character.getNumericValue(number.charAt(i));
                    // 다음의 시작점이 된다. (가장 큰 수의 인덱스 다음 것부터)
                    start = i + 1;
                }
            }
            answer.append(maxVal);
        }

        return answer.toString();
    }
}



/** 시간 초과가 났던 초기 코드. */
//import java.util.*;

//class Solution {
//    static int[] temp;
//    static int length = 0, globalK = 0;
//    static String originNum, targetNum;
//    static String globalAns = "";
//
//    public String solution(String number, int k) {
//        String answer = "";
//        length = number.length();
//        temp = new int[k];
//        globalK = k;
//
//        originNum = number;
//        targetNum = number;
//
//        recur(0, 0);
//        answer = String.valueOf(globalAns);
//        return answer;
//    }
//
//    public void recur(int start, int level) {
//        if (level == globalK) {
//            // temp -> 제거할 수의 인덱스
//            removeStr();
//            return;
//        }
//
//        for(int i=start; i<length; i++) {
//            temp[level] = i;
//            recur(i+1, level+1);
//        }
//    }
//
//    public void removeStr() {
//        StringBuilder tempNum = new StringBuilder("");
//        boolean[] containNums = new boolean[length];
//
//        for(int i=0; i<globalK; i++) {
//            containNums[temp[i]] = true;
//        }
//
//        for(int i=0; i<length; i++) {
//            if (!containNums[i]) {
//                tempNum.append(targetNum.charAt(i));
//            }
//        }
//
//        if (tempNum.toString().compareTo(globalAns) > 0) {
//            globalAns = tempNum.toString();
//        }
//
//        targetNum = originNum;
//    }
//}