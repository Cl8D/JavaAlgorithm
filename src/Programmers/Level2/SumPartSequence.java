package Programmers.Level2;

import java.util.*;

// 연속 부분 수열 합의 개수 - 2번 풀이
// 시간이 더 짧다! (슬라이딩 윈도우 사용)
class Solution {
    private static Set<Integer> sumVals = new HashSet<>();

    public int solution(int[] elements) {
        int answer = 0;
        List<Integer> numbers = new ArrayList<>();
        for (int element : elements) {
            numbers.add(element);
        }

        for (int i=1; i<= elements.length; i++) {
            initNumbers(i, numbers, elements);
            getCount(i, numbers);
        }

        answer = sumVals.size();
        return answer;
    }

    private void getCount(int size, List<Integer> numbers) {
        int sum = 0;
        for (int i=0; i<size; i++) {
            sum += numbers.get(i);
        }
        sumVals.add(sum);

        for (int i=0; i<numbers.size()-size; i++) {
            sum -= numbers.get(i);
            sum += numbers.get(i+size);
            sumVals.add(sum);
        }
    }

    private void initNumbers(int value, List<Integer> numbers, int[] elements) {
        if (value == 1) {
            return;
        }
        numbers.add(elements[value-2]);
    }
}

// 연속 부분 수열 합의 개수 - 1번 풀이
class SumPartSequence {
    private static Set<Integer> sumVals = new HashSet<>();

    public int solution(int[] elements) {
        int answer = 0;
        List<Integer> numbers = new ArrayList<>();
        for (int element : elements) {
            numbers.add(element);
        }

        for (int i=1; i<=elements.length; i++) {
            initNumbers(i, numbers, elements);
            getCount(i, numbers);
        }

        answer = sumVals.size();
        return answer;
    }

    private void getCount(int size, List<Integer> numbers) {
        for (int i=0; i<numbers.size()-size; i++) {
            int sum = 0;
            for (int j=0; j<size; j++) {
                sum += numbers.get(i+j);
            }
            sumVals.add(sum);
        }
    }

    private void initNumbers(int value, List<Integer> numbers, int[] elements) {
        numbers.add(elements[value-1]);
    }
}