package Programmers.Level2;

// 숫자 블록 - 효율성 테스트 통과 X
class NumberBlock {
    public int[] solution(long first, long last) {
        // 어차피 범위가 1_000_000_000이어서 int 써도 상관이 없다.
        int begin = (int) first;
        int end = (int) last;

        int[] answer = new int[end - begin + 1];
        int idx = 0;
        for (int i=begin; i<=end; i++) {
            if (i == 1) {
                answer[idx++] = 0;
                continue;
            }

            answer[idx++] = getMaxDivisor(i);
        }

        return answer;
    }

    private int getMaxDivisor(int value) {
        if (value < 2) {
            return 1;
        }

        // 가장 큰 약수를 가져온다.
        for (int i=2; i<=value; i++) {
            // 효율성 테스트를 위해서는 약수에 대해 블록의 최대 개수가 넘지 않는 조건을 추가해야 한다.
            if (value % i == 0 && value / i <= 10_000_000) {
                return value / i;
            }
        }
        return 1;
    }



}