package Programmers.Level2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// k진수에서 소수 개수 구하기
class GetKDecimalCount {
    public int solution(int n, int k) {
        int answer = 0;

        // n을 k진수로 변환한 결과
        String number = Integer.toString(n, k);

        // 0을 기준으로 자르기
        String[] numberSplitByZero = number.split("0");

        // 0을 기준으로 자르게 되면 연속적인 0에 대해서는 공백이 생길 수 있기 때문에,
        // 필터를 통해서 숫자인 값만 넣어두기.
        List<String> newNums = Arrays.stream(numberSplitByZero).filter(s -> {
            String regex = "[0-9]+";
            return Pattern.matches(regex, s);
        }).collect(Collectors.toList());

        // 기존에 배열을 사용해서 푸는 방법은 long 범위의 배열이 선언이 안 되기 때문에, 그냥 각각 판단하는 로직으로 변경.
        for (String strNum : newNums) {
            Long value = Long.parseLong(strNum);
            if(isPrime(value)) {
                answer++;
            }
        }

        return answer;
    }

    // 에라토스테네스의 체
    private boolean isPrime(long number) {
        if (number < 2) {
            return false;
        }

        for (int i=2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }


}