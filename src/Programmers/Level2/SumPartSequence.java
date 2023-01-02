package Programmers.Level2;

import java.util.*;

// 연속 부분 수열 합의 개수
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