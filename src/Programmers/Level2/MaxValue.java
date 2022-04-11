package Programmers.Level2;

import java.util.Arrays;
import java.util.Comparator;

// 가장 큰 수
public class MaxValue {
    public String solution(int[] numbers) {
        String answer = "";

        String[] strNum = new String[numbers.length];

        for(int i=0; i<numbers.length; i++)
            strNum[i] = String.valueOf(numbers[i]);

        Arrays.sort(strNum, new Comparator<String>() {
            @Override
            // 비교할 기준 정의
            public int compare(String o1, String o2) {
                // o2+o1과 o1+o2를 비교한다.
                // 여기서 o1=3, o2=30이라고 했을 때,
                // 303과 330을 비교하는 것!
                // 즉, 내림차순으로 정렬된다. (더 큰 게 앞으로 가도록)
                // 음... o2+o1가 더 크다면 자리를 바꿔주는 식이라고 생각하면 될 듯.
                return (o2+o1).compareTo(o1+o2);

                // 오름차순 정렬
                // return (o1+o2).compareTo(o2+o1);
            }
        });


        // 처음에 0이 나왔으면 이는 곧 다 0인 거니까 0으로 처리
        if(strNum[0].equals("0"))
            answer = "0";
            // 문자열 처리
            // ""를 기준으로 문자배열열을 합칠 수 있다!
        else
            answer = String.join("", strNum);

        return answer;
    }

}
