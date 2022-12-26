package Programmers.Level2;

import java.util.*;

// 최댓값과 최솟값
class MinMax {
    public String solution(String s) {
        String answer = "";
        StringTokenizer stk = new StringTokenizer(s);

        List<Integer> list = new ArrayList<>();

        while(stk.hasMoreTokens()) {
            list.add(Integer.parseInt(stk.nextToken()));
        }

        list.sort(Comparator.comparingInt(o -> o));

        answer = list.get(0) + " " + list.get(list.size()-1);
        return answer;
    }
}