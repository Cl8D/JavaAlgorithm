package Programmers.Level2;

import java.util.*;

// 조이스틱
class JoyStick {

    public int solution(String name) {
        int answer = 0;

        // 다음으로 확인할 값
        int index = 0;

        int length = name.length();

        // 좌우에 대한 움직임 수를 체크한다.
        // 초기는 순차적으로 움직인다고 가정하고 길이-1만큼이 필요하다.
        int move = length - 1;

        for (int i=0; i<name.length(); i++) {
            // 상하로 움직이는 부분을 더하는 코드.
            // A~N까지는 위로만, M~Z까지는 아래로 가는게 빠르다.
            // 그래서 아스키코드 값을 활용하여 A(65), Z(90)
            answer += Math.min(name.charAt(i) - 'A',
                    'Z' - name.charAt(i) + 1);
            index = i + 1;

            // 좌우의 커서에 대한 코드.
            // A의 연속되는 개수를 기반으로, A 기준 뒷부분의 길이와 앞부분의 길이를 판단한다.
            // 이를 통해 앞/뒤 중 어디가 더 빠른지 계산한다.
            // 현재 위치(타겟된 값 위치 +1)가 length보다 작으면서, 해당 위치의 글자가 A라면 index를 증가시킨다.
            // AAAAAA
            // AAAAAB
            while (index < length && name.charAt(index) == 'A') {
                index++;
            }

            // 순차적으로 가는 기존의 move값과, 뒤로 돌아가는 것 중 이동 수가 적은 것을 선택한다. (중간까지 왔다가 다시 뒤로)
            move = Math.min(move, i * 2 + length - index);

            // 처음부터 뒤로부터 가는 게 더 빠른 경우랑도 비교한다.
            move = Math.min(move, (length - index) * 2 + i);
        }

        return answer + move;
    }

}

/** 생각하다가 포기... */
//import java.util.*;
//
//class Solution {
//    static Map<Character, Integer> upStandard = new HashMap<>();
//    static Map<Character, Integer> downStandard = new HashMap<>();
//
//    public int solution(String name) {
//        // 위쪽 이동
//        // A B C D E F G H I J
//        // 0 1 2 3 4 5 6 7 8 9
//        // K  L  M  N  O  P  Q  R  S  T
//        // 10 11 12 13 14 15 16 17 18 19
//        // U  V  W  X  Y  Z
//        // 20 21 22 23 24 25
//
//        // 아래쪽 이동
//        // A  B  C  D  E  F  G  H  I  J
//        // 0 25 24 23 22 21 20 19 18 17
//        // K  L  M  N  O  P  Q  R S T
//        // 16 15 14 13 12 11 10 9 8 7
//        // U V W X Y Z
//        // 6 5 4 3 2 1
//
//        // 아스키 -> A (65), Z(90)
//
//        // 알파벳 맵 초기화 (위쪽 이동)
//        for(int i=1; i<=13; i++) {
//            upStandard.put((char)(i+65), i);
//        }
//
//        // 아래쪽 이동
//        for(int i=1; i<=12; i++) {
//            downStandard.put((char)(91-i), i);
//        }
//
//        int answer = 0;
//        StringBuilder target = new StringBuilder("");
//        target.append("A".repeat(name.length()));
//
//        int standardIdx = name.indexOf("A");
//        // 만약 A가 없다면 앞에서부터 단순히 탐색 진행
//        if (standardIdx == -1) {
//            return countByOrder(name);
//        }
//        // A가 발견되었다면
//        // 1. 순차 탐색
//        answer = countByOrder(name);
//
//
//        return answer;
//    }
//    private int countByOrder(String name) {
//        int count = 0;
//        for (int i=0; i<name.length(); i++) {
//            if (upStandard.containsKey(name.charAt(i))) {
//                count += upStandard.get(name.charAt(i));
//                count++;
//                continue;
//            }
//            count += downStandard.get(name.charAt(i));
//            count++;
//        }
//        // 마지막 이동의 경우에 대해서는 빼주기
//        count--;
//        return count;
//    }
//}