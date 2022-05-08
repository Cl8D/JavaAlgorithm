package Programmers.Level2;

import java.util.Arrays;
import java.util.Comparator;

// 파일명 정렬
public class FilenameSorting {
    public String[] solution(String[] files) {

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // HEAD = 문자로 이루어져 있음

                // 정규식으로 자르기
                String head1 = o1.split("[0-9]")[0].toUpperCase();
                String head2 = o2.split("[0-9]")[0].toUpperCase();

                // 1. HEAD를 기준으로 사전순 (대소문자 구분 x)
                int result = head1.compareTo(head2); // 기본이 사전순

                // 2. number 숫자순으로 정렬 (실질적인 값으로)
                Integer number1 = makeNumber(o1, head1);
                Integer number2 = makeNumber(o2, head2);

                if(result == 0)
                    result = number1 - number2;

                return result;
            }
        });

        return files;
    }
    public int makeNumber(String o, String head) {
        // number가 시작하는 구간
        String temp = o.substring(head.length());

        String result = "";

        // 런타임 에러 체크 -> Tail이 비어있을 수 있으니까 tail 말고 number 기준으로 하기
        for(char c : temp.toCharArray()) {
            // 오답 체크 -> tail에는 숫자도 올 수 있기 때문에, 숫자 기준 + 길이도 함께 기준으로 봐야 함!
            if(Character.isDigit(c) && result.length() < 5) {
                result += c;
            }
            else
                break;
        }

        return Integer.parseInt(result);

    }


}